package com.identify.design.document

import android.view.View
import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.sdk.document.BaseCardScanModuleModuleFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

class CardScanModuleModuleFragment : BaseCardScanModuleModuleFragment() {

    override fun getFragmentContainer(): Int = R.id.cardScanContainer

    override fun getScanFrontOfCardFragmentInstance(): Fragment = ScanFrontOfCardFragment.newInstance()

    override fun getTakePhotoOtherCardsFragmentInstance(): Fragment = TakePhotoOtherCardsFragment.newInstance()

    override fun getScanPassportFragmentInstance(): Fragment = ScanPassportFragment.newInstance()

    override fun getChooseIdentItemFragmentInstance(): Fragment = ChooseIdentItemFragment.newInstance()

    override fun getScanBackOfCardFragmentInstance(): Fragment = ScanBackOfCardFragment.newInstance()

    override fun getScanBackOfCardInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.SCAN_BACK_OF_CARD_INFORMATION,imgResourceId = R.drawable.kimlikarka,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_back_side))

    override fun getScanPassportInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.SCAN_PASSPORT_INFORMATION,imgResourceId = R.drawable.img_passport,infoTitleText = getString(R.string.mrz_info_title),infoContentText = getString(R.string.nfc_info_desc_passport),isImgFrameVisible = View.VISIBLE)

    override fun getScanFrontOfCardInformationFragmentInstance(): Fragment? =  InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.SCAN_FRONT_OF_CARD_INFORMATION,imgResourceId = R.drawable.kimlikon,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_front_side))

    override fun getDriverLicensePhotoFrontInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.TAKE_PHOTO_FRONT_DRIVER_LICENSE_INFORMATION,imgResourceId = R.drawable.driver_license,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_front_side))

    override fun getDriverLicensePhotoBackInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.TAKE_PHOTO_BACK_DRIVER_LICENSE_INFORMATION,imgResourceId = R.drawable.driver_license,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_back_side))

    override fun getOldIdCardPhotoFrontInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.TAKE_PHOTO_FRONT_OF_OLD_CARD_INFORMATION,imgResourceId = R.drawable.eski_kimlik,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_front_side))

    override fun getOldIdCardPhotoBackInformationFragmentInstance(): Fragment? = InformationDialogFragment.newInstance(identifyInformationTypes = IdentifyInformationTypes.TAKE_PHOTO_BACK_OF_OLD_CARD_INFORMATION,imgResourceId = R.drawable.eski_kimlik,infoTitleText = getString(R.string.take_photo),infoContentText = getString(R.string.id_card_back_side))


    override fun getLayoutRes(): Int = R.layout.fragmet_card_scan_module

    companion object {

        @JvmStatic
        fun newInstance() =
                CardScanModuleModuleFragment()
    }






}