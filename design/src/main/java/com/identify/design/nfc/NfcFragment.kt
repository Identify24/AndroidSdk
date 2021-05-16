package com.identify.design.nfc

import android.os.Bundle
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.util.alert
import com.identify.design.util.showInformationDialog
import com.identify.sdk.mrz.BaseNfcFragment
import kotlinx.android.synthetic.main.fragment_nfc.*
import org.jmrtd.lds.icao.MRZInfo

class NfcFragment : BaseNfcFragment() {



    override fun getLayoutRes(): Int = R.layout.fragment_nfc

    override fun initViews() {
        directCallWaiting = this.directCallWaitingView
        relLayDefaultNfc = this.relLayDefaultNfcView
        linLayReadNfc = this.linLayReadNfcView
        tvNfcStatus = this.tvNfcStatusView
        nfcAnimation = this.nfcAnimationView
        cardNext = this.cardNextView
    }

    override fun showNfcForPassportInformation() {
        this.showInformationDialog(R.raw.nfc,R.drawable.img_passport,getString(R.string.mrz_info_title),getString(R.string.nfc_info_desc_passport))
    }

    override fun showNfcForIdInformation() {
        this.showInformationDialog(R.raw.nfc,null,getString(R.string.mrz_info_title),getString(R.string.nfc_info_desc_id))
    }

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


    companion object {

        @JvmStatic
        fun newInstance(mrzInfo: MRZInfo, scannedText: String) =
            NfcFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("mrzInfo",mrzInfo)
                    putString("scannedText",scannedText)
                }
            }
    }
}