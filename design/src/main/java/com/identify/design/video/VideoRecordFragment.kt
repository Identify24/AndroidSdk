package com.identify.design.video

import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.FragmentVideoRecordBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.video.BaseVideoRecordFragment

class VideoRecordFragment : BaseVideoRecordFragment() {

    val binding by viewBinding(FragmentVideoRecordBinding::bind)


    override fun initViews() {
        btnRecordVideo = binding.cardRecordVideoView
        btnClose = binding.imgCloseView
        btnVideoConfirm = binding.cardVideoConfirmView
        frameVideo = binding.frameVideoView
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        animVideoRecording = binding.animVideoRecordingView
        videoPreview = binding.videoPreviewView
        videoPlayer = binding.videoPlayerView
        tvSecond = binding.tvSecondView
    }

    override fun showVideoRecordInformation() {
       this.showInformationDialog(R.raw.video_record,null, getString(R.string.record_video), getString(R.string.record_video_desc))
    }

    override fun setVideoRecordingAnimation(): Int =  R.raw.video_record

    override fun setVideoRecordingAnimationRepeatCount(): Int = LottieDrawable.INFINITE



    companion object{
        @JvmStatic
        fun newInstance() =
            VideoRecordFragment()
    }


    override fun getLayoutRes(): Int = R.layout.fragment_video_record
}