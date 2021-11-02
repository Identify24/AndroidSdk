package com.identify.design.liveness

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.face.BaseLivenessDetectionModuleFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

class LivenessDetectionModuleFragment : BaseLivenessDetectionModuleFragment() {

    override fun getLivenessDetectionFragmentInstance(): Fragment? = LivenessDetectionFragment.newInstance()

    override fun getLivenessDetectionInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.LIVENESS_INFORMATION,imgResourceId = R.drawable.ic_vitality_illustration,infoTitleText = getString(R.string.vitality_title),infoContentText = getString(R.string.liveness_description))

    override fun getSmileDetectionInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.LIVENESS_SMILE_INFORMATION,animResourceId = R.raw.smile,infoTitleText = getString(R.string.vitality_title),infoContentText = getString(R.string.smiling_text_content))

    override fun getBlinkDetectionInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.LIVENESS_BLINK_INFORMATION,animResourceId = R.raw.blink_couple,infoTitleText = getString(R.string.vitality_title),infoContentText = getString(R.string.blink_text))

    override fun getTurnRightDetectionInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.LIVENESS_TURN_RIGHT_INFORMATION,animResourceId = R.raw.look_right, infoTitleText = getString(R.string.vitality_title),infoContentText = getString(R.string.turn_your_head_right_text))

    override fun getTurnLeftDetectionInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.LIVENESS_TURN_LEFT_INFORMATION,animResourceId = R.raw.look_left,infoTitleText = getString(R.string.vitality_title),infoContentText = getString(R.string.turn_your_head_left_text))

    override fun getFragmentContainer(): Int  = R.id.livenessContainer

    override fun getLayoutRes(): Int = R.layout.fragment_liveness_module




    companion object {
        @JvmStatic
        fun newInstance() = LivenessDetectionModuleFragment()
    }
}