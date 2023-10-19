package com.identify.design.nfc

import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.design.dialogs.NfcMissingDataBottomDialogFragment
import com.identify.sdk.mrz.BaseNfcModuleFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

class NfcModuleFragment : BaseNfcModuleFragment() {

    override fun getFragmentContainer(): Int = R.id.nfcContainer

    override fun getNfcFragmentInstance() : Fragment? = NfcFragment.newInstance()

    override fun getNfcNotAvailableFragment(): Fragment?  = NfcNotAvailableFragment.newInstance()

    override fun getCheckIdentityInformationFragmentInstance(): DialogFragment? = CheckIdentityInformationFragment.newInstance()

    override fun getIdCardNfcInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes =  IdentifyInformationTypes.ID_CARD_NFC_INFORMATION,animResourceId = R.raw.nfc, infoTitleText = getString(R.string.mrz_info_title), infoContentText = getString(R.string.nfc_info_desc_id))

    override fun getPassportNfcInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.PASSPORT_NFC_INFORMATION,animResourceId = R.raw.nfc,infoTitleText = getString(R.string.mrz_info_title),infoContentText = getString(R.string.nfc_info_desc_passport))

    override fun getNfcMissingDataFragmentInstance(): DialogFragment? = NfcMissingDataBottomDialogFragment.newInstance()
    override fun getLayoutRes(): Int = R.layout.fragment_nfc_module

    companion object {
        @JvmStatic
        fun newInstance() = NfcModuleFragment()
    }

}