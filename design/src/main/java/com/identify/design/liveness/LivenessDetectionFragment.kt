package com.identify.design.liveness

import android.os.Bundle
import com.identify.design.R
import com.identify.design.databinding.FragmentLivenessDetectionBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.face.BaseLivenessDetectionFragment

class LivenessDetectionFragment : BaseLivenessDetectionFragment() {


    val binding by viewBinding(FragmentLivenessDetectionBinding::bind)


    override fun initViews() {
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        livenessPreview = binding.livenessPreviewView
        smileRating = binding.smileRatingView
        tvFaceStatus = binding.tvFaceStatusView
        animSuccessStatus = binding.successStatusAnimationView
    }

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
       this.hideProgressDialog()
    }

    override fun changeStatusColor(): Int? {
        return R.color.colorGreen
    }


    override fun startingBlinkProcess() {
        binding.tvFaceStatusView.text = getString(R.string.blink_text)
    }

    override fun startingSmileProcess() {
        binding.tvFaceStatusView.text = getString(R.string.smiling_text)
    }

    override fun startingTurnLeftProcess() {
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_left_text)
    }

    override fun startingTurnRightProcess() {
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_right_text)
    }

    override fun finishedLivenessDetection() {
        binding.tvFaceStatusView.text = getString(R.string.finish_vitality_process)
    }


    override fun getSuccessAnimationId(): Int = R.raw.smile

    override fun getSuccessAnimationRepeatCount(): Int = 0

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