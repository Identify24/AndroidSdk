package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentTakePhotoOtherCardsBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseTakePhotoOtherCardsFragment

class TakePhotoOtherCardsFragment : BaseTakePhotoOtherCardsFragment() {

    val binding by viewBinding(FragmentTakePhotoOtherCardsBinding::bind)

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun initViews() {

        btnPictureConfirm = binding.tvGoOn
        btnTakePicture = binding.cardTakePictureView
        btnClose = binding.tvAgainTakePhoto
        relLayPictureConfirm = binding.relLayPictureConfirmView
        imgCapturedImage  = binding.imgCapturedImageView
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
        documentPreview  = binding.documentPreviewView
    }

    override fun getLayoutRes(): Int = R.layout.fragment_take_photo_other_cards


    companion object {

        @JvmStatic
        fun newInstance() =
            TakePhotoOtherCardsFragment()
    }
}