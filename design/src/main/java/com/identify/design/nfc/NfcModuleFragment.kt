package com.identify.design.nfc

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcModuleBinding
import com.identify.design.flowbreak.FlowBreakFragment
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseNfcModuleFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import org.jmrtd.lds.icao.MRZInfo

class NfcModuleFragment : BaseNfcModuleFragment() {

    val binding by viewBinding(FragmentNfcModuleBinding::bind)

    override fun getFragmentContainer(): Int = R.id.frameFragmentContainer

    override fun initViews() {
        btnContinue = binding.cardcontinueBtnView
        relLayNotAvailableNfc = binding.relLayNotAvailableNfcView
    }

    //ocr bittiğinde nfc başlamadan arasına custom dialog eklemek için kullanılabilir.
   /* override fun getCustomNfcInformationDialogFragment(): DialogFragment? {
        return FlowBreakFragment.newInstance(IdentifyInformationTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO_INFORMATION)
    }*/


    override fun getOcrFragmentInstance() : Fragment = OcrFragment.newInstance()

    override fun getNfcFragmentInstance(mrzInfo: MRZInfo,scannedText : String?) : Fragment = NfcFragment.newInstance(mrzInfo,scannedText)

    override fun getLayoutRes(): Int = R.layout.fragment_nfc_module

    companion object {
        @JvmStatic
        fun newInstance() = NfcModuleFragment()
    }

}