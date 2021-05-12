package com.identify.design.signature

import com.identify.design.R
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.signature.BaseSignatureFragment
import kotlinx.android.synthetic.main.fragment_signature.*

class SignatureFragment : BaseSignatureFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_signature

    override fun initViews() {
        cardClearBtn = this.cardClearBtnView
        signaturePad = this.signaturePadView
        cardConfirmBtn = this.cardConfirmBtnView
        directCallWaiting = this.directCallWaitingView
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

}