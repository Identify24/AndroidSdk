package com.identify.design.dialogs

import com.identify.design.R
import com.identify.design.databinding.FragmentDialogNfcMissingDataBinding
import com.identify.sdk.base.BaseNfcMissingDataBottomDialogFragment
import com.identify.sdk.base.viewBinding.viewBinding

class NfcMissingDataBottomDialogFragment:BaseNfcMissingDataBottomDialogFragment() {

    val binding by viewBinding(FragmentDialogNfcMissingDataBinding::bind)

    override fun initViews() {
        etSerialNumber = binding.etSerialNumber
        tvDateOfBirth = binding.tvDateOfBirth
        tvExpiryDate = binding.tvExpiryDate
        btnUpdate = binding.cvUpdate
    }

    override fun getDocumentNoErrorMessage(): String = getString(R.string.document_num_error)

    override fun getDateOfBirthErrorMessage(): String = getString(R.string.birth_day_error)

    override fun getValidUntilErrorMessage(): String = getString(R.string.expiry_day_error)

    companion object {

        @JvmStatic
        fun newInstance() =
            NfcMissingDataBottomDialogFragment()
    }

    override fun getLayoutRes():Int = R.layout.fragment_dialog_nfc_missing_data
}