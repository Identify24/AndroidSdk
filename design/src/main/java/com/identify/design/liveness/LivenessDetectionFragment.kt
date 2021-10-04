package com.identify.design.liveness

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentLivenessDetectionBinding
import com.identify.design.flowbreak.FlowBreakFragment
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.face.BaseLivenessDetectionFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

class LivenessDetectionFragment : BaseLivenessDetectionFragment() {


    val binding by viewBinding(FragmentLivenessDetectionBinding::bind)


    override fun initViews() {
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        livenessPreview = binding.livenessPreviewView
        smileRating = binding.smileRatingView
        tvFaceStatus = binding.tvFaceStatusView
        animSuccessStatus = binding.successStatusAnimationView
    }

    override fun changeStatusColor(): Int? {
        return R.color.colorGreen
    }


    override fun startingBlinkProcess() {
       // this.showInformationDialog(R.raw.blink_couple,null,getString(R.string.vitality_title),getString(R.string.blink_text))
        binding.tvFaceStatusView.text = getString(R.string.blink_text)
    }

    override fun startingSmileProcess() {
        //this.showInformationDialog(R.raw.smile,null,getString(R.string.vitality_title),getString(R.string.smiling_text_content),0)
        binding.tvFaceStatusView.text = getString(R.string.smiling_text)
    }

    override fun startingTurnLeftProcess() {
        // this.showInformationDialog(R.raw.look_left,null,getString(R.string.vitality_title),getString(R.string.turn_your_head_left_text))
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_left_text)
    }

    override fun startingTurnRightProcess() {
      //  this.showInformationDialog(R.raw.look_right,null,getString(R.string.vitality_title),getString(R.string.turn_your_head_right_text))
        binding.tvFaceStatusView.text = getString(R.string.turn_your_head_right_text)
    }

    override fun finishedLivenessDetection() {
        binding.tvFaceStatusView.text = getString(R.string.finish_vitality_process)
        super.finishedLivenessDetection()
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