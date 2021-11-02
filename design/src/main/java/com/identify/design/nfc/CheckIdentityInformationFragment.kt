package com.identify.design.nfc

import com.identify.design.R
import com.identify.design.databinding.FragmentCheckIdentityInformationBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseCheckIdentityInformationFragment

class CheckIdentityInformationFragment : BaseCheckIdentityInformationFragment() {

    val binding by viewBinding(FragmentCheckIdentityInformationBinding::bind)


    override fun initViews() {
        btnSave = binding.btnSaveView
        tvExpireDay = binding.tvExpireDayView
        tvBirthDay = binding.tvBirthDayView
        edtDocNumber = binding.edtDocNumberView
    }

    override fun getDocumentNumberErrorText(): String? = getString(R.string.document_num_error)

    override fun getBirthDayErrorText(): String? = getString(R.string.birth_day_error)

    override fun getExpiryDayErrorText(): String? = getString(R.string.expiry_day_error)

    override fun getLayoutRes(): Int = R.layout.fragment_check_identity_information


    companion object {

        @JvmStatic
        fun newInstance() =
            CheckIdentityInformationFragment()
    }

}