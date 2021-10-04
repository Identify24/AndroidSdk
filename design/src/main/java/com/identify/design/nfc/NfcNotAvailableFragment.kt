package com.identify.design.nfc


import com.identify.design.R
import com.identify.design.databinding.FragmentNfcNotAvailableBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseNfcNotAvailableFragment

class NfcNotAvailableFragment : BaseNfcNotAvailableFragment() {

    val binding by viewBinding(FragmentNfcNotAvailableBinding::bind)

    override fun initViews() {
        btnContinue = binding.continueBtnView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getLayoutRes(): Int = R.layout.fragment_nfc_not_available

    companion object {

        @JvmStatic
        fun newInstance() =
                NfcNotAvailableFragment()
    }
}