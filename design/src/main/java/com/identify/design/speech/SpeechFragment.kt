package com.identify.design.speech


import androidx.core.content.ContextCompat
import com.identify.design.R
import com.identify.design.util.showInformationDialog
import com.identify.sdk.speech.BaseSpeechFragment
import kotlinx.android.synthetic.main.fragment_speech.*

class SpeechFragment : BaseSpeechFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_speech

    override fun initViews() {
        directCallWaiting = this.directCallWaitingView
        btnConfirm = this.btnConfirmView
        tvSpeech = this.tvSpeechView
        ibMicrophone = this.ibMicrophoneView

    }

    override fun showSpeechInformation() {
        this.showInformationDialog(R.raw.speech, null, getString(R.string.vitality_title), getString(R.string.speech_info_desc))
    }

    override fun errorWrongTextPlsTryAgainText(): String = getString(R.string.wrong_text_pls_try)

    override fun microphoneTouchedWithActionUp() {
        ibMicrophoneView.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.circle_style)
        tvVoiceNote.text = getString(R.string.speech_desc)
    }

    override fun microphoneTouchedWithActionDown() {
        ibMicrophoneView.background =   ContextCompat.getDrawable(requireContext(), R.drawable.circle_style_listening)
        tvVoiceNote.text = getString(R.string.now_speech)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SpeechFragment()
    }
}