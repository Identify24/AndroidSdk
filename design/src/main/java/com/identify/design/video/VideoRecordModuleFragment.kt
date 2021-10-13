package com.identify.design.video

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.video.BaseVideoRecordModuleFragment

class VideoRecordModuleFragment : BaseVideoRecordModuleFragment() {

    override fun getVideoRecordFragmentInstance(): Fragment? = VideoRecordFragment.newInstance()

    override fun getVideoRecordInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.VIDEO_RECORD_INFORMATION,animResourceId = R.raw.video_record, infoTitleText = getString(R.string.record_video),infoContentText = getString(R.string.record_video_desc))

    override fun getFragmentContainer(): Int = R.id.videoRecordContainer

    override fun getLayoutRes(): Int = R.layout.fragment_video_record_module


    companion object{
        @JvmStatic
        fun newInstance() =
                VideoRecordModuleFragment()
    }
}