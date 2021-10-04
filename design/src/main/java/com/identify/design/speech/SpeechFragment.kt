package com.identify.design.speech


import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentSignatureBinding
import com.identify.design.databinding.FragmentSpeechBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.speech.BaseSpeechFragment

class SpeechFragment : BaseSpeechFragment() {

    val binding by viewBinding(FragmentSpeechBinding::bind)

    override fun initViews() {
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        btnConfirm = binding.btnConfirmView
        tvSpeech = binding.tvSpeechView
        ibMicrophone = binding.ibMicrophoneView
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen



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

    override fun getLayoutRes(): Int = R.layout.fragment_speech
}