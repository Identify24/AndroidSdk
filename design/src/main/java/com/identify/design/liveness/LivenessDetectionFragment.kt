package com.identify.design.liveness

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentLivenessDetectionBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.face.BaseLivenessDetectionFragment

class LivenessDetectionFragment : BaseLivenessDetectionFragment() {


    val binding by viewBinding(FragmentLivenessDetectionBinding::bind)


    override fun initViews() {
        directCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        livenessPreview = binding.livenessPreviewView
        smileRating = binding.smileRatingView
        tvFaceStatus = binding.tvFaceStatusView
        successStatusAnimation = binding.successStatusAnimationView
    }

    override fun showLivenessFinishedInformation() {
        this.showInformationDialog(R.raw.success,null,getString(R.string.vitality_title),getString(R.string.finish_vitality_process))
    }

    override fun getLivenessFinishedStatusText(): String = getString(R.string.finish_vitality_process)

    override fun getSuccessAnimationId(): Int = R.raw.smile

    override fun getSuccessAnimationRepeatCount(): Int = 0

    override fun livenessDetectionModuleFinished() {
        finish()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_liveness_detection


    override fun showSmileInformation() {
        this.showInformationDialog(R.raw.smile,null,getString(R.string.vitality_title),getString(R.string.smiling_text_content),0)
    }

    override fun getSmileStatusText(): String  = getString(R.string.smiling_text)

    override fun showBlinkInformation() {
        this.showInformationDialog(R.raw.blink_couple,null,getString(R.string.vitality_title),getString(R.string.blink_text))
    }

    override fun getBlinkStatusText(): String = getString(R.string.blink_text)

    override fun showLookRightInformation() {
        this.showInformationDialog(R.raw.look_right,null,getString(R.string.vitality_title),getString(R.string.turn_your_head_right_text))
    }

    override fun getLookRightStatusText(): String = getString(R.string.turn_your_head_right_text)


    override fun showLookLeftInformation() {
        this.showInformationDialog(R.raw.look_left,null,getString(R.string.vitality_title),getString(R.string.turn_your_head_left_text))
    }

    override fun getLookLeftStatusText(): String = getString(R.string.turn_your_head_left_text)


    companion object {

        @JvmStatic
        fun newInstance() =
            LivenessDetectionFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}