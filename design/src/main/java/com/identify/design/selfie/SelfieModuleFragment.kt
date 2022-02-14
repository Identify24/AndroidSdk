package com.identify.design.selfie

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.selfie.BaseSelfieModuleFragment

class SelfieModuleFragment : BaseSelfieModuleFragment() {

    override fun getSelfieFragmentInstance(): Fragment? = SelfieFragment.newInstance()

    override fun getSelfieInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.TAKE_SELFIE_INFORMATION,animResourceId = R.raw.selfie,infoTitleText =  getString(R.string.take_photo), infoContentText =  getString(R.string.pls_take_selfie))

    override fun getFragmentContainer(): Int = R.id.selfieContainer

    override fun getLayoutRes(): Int = R.layout.fragment_selfie_module


    companion object {

        @JvmStatic
        fun newInstance() =
                SelfieModuleFragment()
    }
}