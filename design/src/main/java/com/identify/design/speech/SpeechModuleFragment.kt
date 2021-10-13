package com.identify.design.speech

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.speech.BaseSpeechModuleFragment

class SpeechModuleFragment : BaseSpeechModuleFragment() {

    override fun getSpeechFragmentInstance(): Fragment? = SpeechFragment.newInstance()

    override fun getSpeechInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.SPEECH_TEST_INFORMATION,animResourceId = R.raw.speech,infoTitleText =  getString(R.string.vitality_title),infoContentText =  getString(R.string.speech_info_desc))

    override fun getFragmentContainer(): Int = R.id.speechContainer

    override fun getLayoutRes(): Int  = R.layout.fragment_speech_module



    companion object{
        @JvmStatic
        fun newInstance() =
                SpeechModuleFragment()
    }
}