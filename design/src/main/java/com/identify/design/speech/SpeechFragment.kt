package com.identify.design.speech


import androidx.core.content.ContextCompat
import com.identify.design.R
import com.identify.design.databinding.FragmentSpeechBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.speech.BaseSpeechFragment

class SpeechFragment : BaseSpeechFragment<FragmentSpeechBinding>() {


    override fun getLayoutRes(): Int = R.layout.fragment_speech

    override fun initViews() {
        directCallWaiting = binding.directCallWaitingView
        btnConfirm = binding.btnConfirmView
        tvSpeech = binding.tvSpeechView
        ibMicrophone = binding.ibMicrophoneView
    }

    override fun showSpeechInformation() {
        showInformationDialog(R.raw.speech, null, getString(R.string.vitality_title), getString(R.string.speech_info_desc))
    }

    override fun errorWrongTextPlsTryAgainText(): String = getString(R.string.wrong_text_pls_try)

    override fun microphoneTouchedWithActionUp() {
        binding.ibMicrophoneView.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.circle_style)
        binding.tvVoiceNote.text = getString(R.string.speech_desc)
    }

    override fun microphoneTouchedWithActionDown() {
        binding.ibMicrophoneView.background =   ContextCompat.getDrawable(requireContext(), R.drawable.circle_style_listening)
        binding.tvVoiceNote.text = getString(R.string.now_speech)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SpeechFragment()
    }

    override fun speechModuleFinished() {
        finish()
    }
}