package com.identify.design.liveness

import android.animation.Animator
import android.os.Bundle
import android.view.View
import com.identify.design.R
import com.identify.design.databinding.FragmentLivenessDetectionBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.ApiResponseStatusListener
import com.identify.sdk.base.*
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.face.BaseLivenessDetectionFragment
import com.identify.sdk.face.SelfieProcessListener
import com.identify.sdk.face.SelfieListener
import com.identify.sdk.repository.model.enums.FaceDetectionProcessType
import com.identify.sdk.repository.model.enums.UploadImageType
import com.identify.sdk.scanner.State
import com.identify.sdk.toasty.Toasty

class LivenessDetectionFragment : BaseLivenessDetectionFragment() {


    val binding by viewBinding(FragmentLivenessDetectionBinding::bind)

    private fun hideLivenessProgress(){
        binding.livenessProgressView.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.directCallWaitingView.cardDirectCallWaiting.setOnClickListener {
            redirectCall()
        }

        listenSelfieProcess(object : SelfieProcessListener{
            override fun startedSmileProcess() {
                hideLivenessProgress()
                startingSmileProcess()
                changeStatusColor()?.let { changeStatusBar(it) }
                binding.smileRatingView.isEnabled = true
            }

            override fun finishedSmileProcess() {
                binding.smileRatingView.isEnabled = false
                vibrateDevice()
            }

            override fun startedBlinkProcess() {
                hideLivenessProgress()
                startingBlinkProcess()
                changeStatusColor()?.let { changeStatusBar(it) }
            }

            override fun finishedBlinkProcess() {
                vibrateDevice()
            }

            override fun startedHeadRightProcess() {
                hideLivenessProgress()
                startingTurnRightProcess()
                changeStatusColor()?.let { changeStatusBar(it) }
            }

            override fun finishedHeadRightProcess() {
                vibrateDevice()
            }

            override fun startedHeadLeftProcess() {
                hideLivenessProgress()
                startingTurnLeftProcess()
                changeStatusColor()?.let { changeStatusBar(it) }
            }

            override fun finishedHeadLeftProcess() {
                vibrateDevice()
            }

        })

        listenSmileStatus{
            if (binding.smileRatingView.selectedSmiley != it)
                binding.smileRatingView.setRating(it, true)
            binding.smileRatingView.disallowSelection(true)
        }

        startCamera(binding.livenessPreviewView, object : SelfieListener {
            override fun onPhotoCaptured(photoBase64: String, imageStatusType: UploadImageType) {
                uploadPhoto(photoBase64, imageStatusType, object : ApiResponseStatusListener {
                    override fun onSuccess() {
                        animationStart()
                    }

                    override fun onFailure(r: Reason) {
                        handleError(r)
                        retryAllProcess()
                        startingSmileProcess()
                    }

                    override fun onState(state: State) {
                        when (state) {
                            State.LOADING -> showProgress()
                            State.LOADED -> hideProgress()
                        }
                    }
                })
            }
        }) { t ->
            t.message?.let {
                Toasty.error(
                    requireContext(),
                    it, Toasty.LENGTH_SHORT, true
                ).show()
            }
        }
    }

    private fun animationStart(){
        binding.successStatusAnimationView.visibility = View.VISIBLE
        binding.successStatusAnimationView.setAnimation(getSuccessAnimationId())
        binding.successStatusAnimationView.repeatCount = getSuccessAnimationRepeatCount()

        binding.successStatusAnimationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                when(faceDetectionFinishedProcessType){
                    FaceDetectionProcessType.SMILING ->{
                        finishSmileDetectionFragment()
                        startingBlinkProcess()
                    }
                    FaceDetectionProcessType.BLINK ->{
                        finishBlinkDetectionFragment()
                        startingTurnRightProcess()
                    }
                    FaceDetectionProcessType.HEAD_RIGHT ->{
                        finishTurnRightFragment()
                        startingTurnLeftProcess()
                    }
                    FaceDetectionProcessType.HEAD_LEFT ->{
                        finishTurnLeftFragment()
                        finishedLivenessDetection()
                    }
                    FaceDetectionProcessType.NOT_AVAILABLE -> {}
                    null -> {}
                }
                binding.successStatusAnimationView.removeAllAnimatorListeners()
                binding.successStatusAnimationView.visibility = View.GONE

            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationStart(p0: Animator) {

            }

        })
        binding.successStatusAnimationView.playAnimation()
    }

    private fun handleError(reason :Reason){
        when(reason){
            is ApiError -> {
                Toasty.error(requireContext(), reason.message?.get(0).toString(), Toasty.LENGTH_SHORT, true).show()
            }
            is ResponseError -> {
                Toasty.error(requireContext(), getResponseErrorMessage(), Toasty.LENGTH_SHORT, true).show()
            }
            is SocketConnectionError -> {
                Toasty.error(requireContext(), getSocketConnectionErrorMessage(), Toasty.LENGTH_SHORT, true).show()
            }
            is TimeoutError -> {
                Toasty.error(requireContext(), getTimeoutErrorMessage(), Toasty.LENGTH_SHORT, true).show()
            }
            is ApiComparisonError -> {
                Toasty.error(requireContext(), reason.message?.get(0).toString(), Toasty.LENGTH_SHORT, true).show()
            }
        }
    }

    private fun showProgress() {
        this.showProgressDialog()
    }

    private fun hideProgress() {
       this.hideProgressDialog()
    }

    override fun changeStatusColor(): Int? {
        return R.color.colorGreen
    }


    private fun getResponseErrorMessage(): String = getString(R.string.reason_response)

    private fun getTimeoutErrorMessage(): String = getString(R.string.reason_timeout)

    private fun getSocketConnectionErrorMessage(): String = getString(R.string.reason_socket_connection)

    private fun startingBlinkProcess() {
        binding.tvFaceStatusView.text = getString(R.string.blink_text)
    }

    private fun startingSmileProcess() {
        binding.tvFaceStatusView.text = getString(R.string.smiling_text)
    }

    private fun startingTurnLeftProcess() {
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_left_text)
    }

    private fun startingTurnRightProcess() {
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_right_text)
    }

    private fun finishedLivenessDetection() {
        binding.tvFaceStatusView.text = getString(R.string.finish_vitality_process)
    }

    private fun getSuccessAnimationId(): Int = R.raw.smile

    private fun getSuccessAnimationRepeatCount(): Int = 0

    override fun getLayoutRes(): Int = R.layout.fragment_liveness_detection




    companion object {

        @JvmStatic
        fun newInstance() =
            LivenessDetectionFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}