package com.identify.design.nfc

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.sdk.mrz.BaseNfcModuleFragment
import kotlinx.android.synthetic.main.fragment_nfc_module.*
import org.jmrtd.lds.icao.MRZInfo

class NfcModuleFragment : BaseNfcModuleFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_nfc_module

    override fun getFragmentContainer(): Int = R.id.frameFragmentContainer

    override fun initViews() {
        cardContinueBtn = this.cardcontinueBtnView
        relLayNotAvailableNfc = this.relLayNotAvailableNfcView
    }

    override fun getOcrFragmentInstance() : Fragment = OcrFragment.newInstance()

    override fun getNfcFragmentInstance(mrzInfo: MRZInfo,scannedText : String) : Fragment = NfcFragment.newInstance(mrzInfo,scannedText)

    companion object {
        @JvmStatic
        fun newInstance() = NfcModuleFragment()
    }
}