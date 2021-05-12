package com.identify.design.video

import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.util.showInformationDialog
import com.identify.sdk.video.BaseVideoRecordFragment
import kotlinx.android.synthetic.main.fragment_video_record.*

class VideoRecordFragment : BaseVideoRecordFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_video_record

    override fun initViews() {
        cardRecordVideo = this.cardRecordVideoView
        imgClose = this.imgCloseView
        cardVideoConfirm = this.cardVideoConfirmView
        frameVideo = this.frameVideoView
        directCallWaiting = this.directCallWaitingView
        animVideoRecording = this.animVideoRecordingView
        videoPreview = this.videoPreviewView
        videoPlayer = this.videoPlayerView
        tvSecond = this.tvSecondView
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
}