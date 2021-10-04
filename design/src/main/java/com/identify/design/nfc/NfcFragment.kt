package com.identify.design.nfc

import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcBinding
import com.identify.design.util.alert
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseNfcFragment
import org.jmrtd.lds.icao.MRZInfo

class NfcFragment : BaseNfcFragment() {

    val binding by viewBinding(FragmentNfcBinding::bind)


    override fun initViews() {
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        relLayDefaultNfc = binding.relLayDefaultNfcView
        linLayReadNfc = binding.linLayReadNfcView
        tvNfcStatus = binding.tvNfcStatusView
        animNfc = binding.nfcAnimationView
        btnNext = binding.cardNextView
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen


    override fun getNfcFailToastMessage(): String = getString(R.string.nfc_toast_message)

    override fun getNfcReadingText(): String = getString(R.string.nfc_reading)

    override fun getNfcSuccessText(): String = getString(R.string.nfc_success)

    override fun getNfcTryAgainText(): String = getString(R.string.nfc_try_again)

    override fun showNfcMaxTryErrorDialog(nextClicked: () -> Unit) {
        requireContext().alert(false, getString(R.string.go_on),null,getString(R.string.nfc_error_count_title),getString(
            R.string.nfc_error_count_desc),{ dialog ->
            nextClicked()
            dialog.dismiss()
        },{},{})
    }

    override fun setReadingNfcAnimation(): Int = R.raw.nfc_reading

    override fun setReadingNfcAnimationRepeatCount(): Int = LottieDrawable.INFINITE

    override fun setNfcSuccessFinishedAnimation(): Int = R.raw.nfc_success


    override fun setNfcFailFinishedAnimation(): Int = R.raw.nfc_fail

    override fun setNfcReadingFinishedAnimationRepeatCount(): Int = 0

    override fun errorNfcReadText(): String = getString(R.string.nfc_toast_message)

    override fun getLayoutRes(): Int = R.layout.fragment_nfc



    companion object {

        @JvmStatic
        fun newInstance() =
            NfcFragment()
    }
}