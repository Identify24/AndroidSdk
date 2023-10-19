package com.identify.design.dialogs

import android.animation.Animator
import android.view.View
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.FragmentBottomNfcWhenCallingBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.started.BaseNfcWhenCallingBottomDialogFragment

class NfcWhenCallingBottomDialogFragmentBottomDialogFragment : BaseNfcWhenCallingBottomDialogFragment() {

    val binding by viewBinding(FragmentBottomNfcWhenCallingBinding::bind)

    override fun startNfcReading() {
        binding.relLayDefaultNfcView.visibility = View.GONE
        binding.linLayReadNfcView.visibility = View.VISIBLE
        binding.tvNfcStatusView.text = getString(R.string.nfc_reading)
        binding.nfcAnimationView.setAnimation(R.raw.nfc_reading)
        binding.nfcAnimationView.repeatCount = LottieDrawable.INFINITE
        binding.nfcAnimationView.playAnimation()
    }

    override fun errorNfcReading() {

        binding.nfcAnimationView.setAnimation(R.raw.nfc_fail)
        binding.tvNfcStatusView.text = getString(R.string.nfc_try_again)
        binding.nfcAnimationView.repeatCount = 0
        binding.nfcAnimationView.playAnimation()
    }

    override fun finishedNfcReading(finishPage: () -> Unit) {

        binding.nfcAnimationView.setAnimation(R.raw.nfc_success)
        binding.tvNfcStatusView.text = getString(R.string.nfc_success)
        binding.nfcAnimationView.repeatCount = 0
        binding.nfcAnimationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
               finishPage()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })
        binding.nfcAnimationView.playAnimation()

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NfcWhenCallingBottomDialogFragmentBottomDialogFragment()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_bottom_nfc_when_calling
}