package com.identify.design.nfc

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcModuleBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseNfcModuleFragment
import com.identify.sdk.repository.model.dto.MrzDto
import org.jmrtd.lds.icao.MRZInfo

class NfcModuleFragment : BaseNfcModuleFragment() {

    val binding by viewBinding(FragmentNfcModuleBinding::bind)

    override fun getFragmentContainer(): Int = R.id.frameFragmentContainer

    override fun initViews() {
        cardContinueBtn = binding.cardcontinueBtnView
        relLayNotAvailableNfc = binding.relLayNotAvailableNfcView
    }


    override fun getOcrFragmentInstance() : Fragment = OcrFragment.newInstance()

    override fun getNfcFragmentInstance(mrzInfo: MRZInfo,scannedText : String?) : Fragment = NfcFragment.newInstance(mrzInfo,scannedText)

    override fun getLayoutRes(): Int = R.layout.fragment_nfc_module

    companion object {
        @JvmStatic
        fun newInstance() = NfcModuleFragment()
    }

    override fun nfcModuleFinished(isSuccess: Boolean, mrzDto: MrzDto?) {
        finish(isSuccess,mrzDto)
    }
}