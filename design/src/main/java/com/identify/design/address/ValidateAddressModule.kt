package com.identify.design.address

import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.address.BaseValidateAddressModule
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

class ValidateAddressModule : BaseValidateAddressModule() {

    override fun getFragmentContainer(): Int = R.id.validateAddressContainer

    override fun getEnterAddressFragmentInstance(): Fragment? = EnterAddressFragment.newInstance()

    override fun getTakeAddressPhotoFragmentInstance(): Fragment? = TakeAddressPhotoFragment.newInstance()

    override fun getEnterAddressInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.VALIDATE_ADDRESS_INFORMATION,animResourceId = R.raw.location,infoTitleText = getString(R.string.address_info_title),infoContentText = getString(R.string.address_info_content))

    override fun getLayoutRes(): Int  = R.layout.fragment_validate_address_module


    companion object {
        @JvmStatic
        fun newInstance() =
            ValidateAddressModule()
    }
}