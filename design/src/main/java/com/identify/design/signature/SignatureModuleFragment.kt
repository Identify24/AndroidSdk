package com.identify.design.signature

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.signature.BaseSignatureModuleFragment

class SignatureModuleFragment : BaseSignatureModuleFragment() {
    override fun getSignatureFragmentInstance(): Fragment? = SignatureFragment.newInstance()

    override fun getSignatureInformationFragmentInstance(): Fragment  ?= InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.SIGNATURE_INFORMATION,animResourceId = R.raw.signature,infoTitleText = getString(R.string.pls_sign),infoContentText = getString(R.string.pls_sign_desc))

    override fun getFragmentContainer(): Int = R.id.signatureContainer

    override fun getLayoutRes(): Int = R.layout.fragment_signature_module

/*
    Modül bitiminde araya girip ekran göstermek istenirse

    override fun signatureModuleFinished() {
        childFragmentManager.beginTransaction().replace(getFragmentContainer(),InformationDialogFragment.newInstance(identifyModuleTypes = IdentifyModuleTypes.DIJITAL_SIGNATURE,animResourceId = R.raw.signature,infoTitleText = getString(R.string.pls_sign),infoContentText = getString(R.string.pls_sign_desc)),InformationDialogFragment::class.java.toString()).commitAllowingStateLoss()
    }*/

    companion object {

        @JvmStatic
        fun newInstance() =
                SignatureModuleFragment()
    }

}