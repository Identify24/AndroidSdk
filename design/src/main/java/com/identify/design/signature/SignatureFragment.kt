package com.identify.design.signature

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentSelfieBinding
import com.identify.design.databinding.FragmentSignatureBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.signature.BaseSignatureFragment

class SignatureFragment : BaseSignatureFragment() {

    val binding by viewBinding(FragmentSignatureBinding::bind)


    override fun initViews() {
        cardClearBtn = binding.cardClearBtnView
        signaturePad = binding.signaturePadView
        cardConfirmBtn = binding.cardConfirmBtnView
        directCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
    }

    override fun showSignatureInformation() {
       this.showInformationDialog(R.raw.signature,null,getString(R.string.pls_sign),getString(R.string.pls_sign_desc))
    }

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun errorNoSignatureMessage(): String = getString(R.string.pls_sign_desc)

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SignatureFragment()
    }

    override fun signatureModuleFinished() {
        finish()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_signature

}