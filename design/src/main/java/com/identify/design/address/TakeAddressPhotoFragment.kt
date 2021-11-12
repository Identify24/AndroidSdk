package com.identify.design.address

import com.identify.design.R
import com.identify.design.databinding.FragmentTakeAddressPhotoBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.address.BaseTakeAddressPhotoFragment
import com.identify.sdk.base.viewBinding.viewBinding

class TakeAddressPhotoFragment : BaseTakeAddressPhotoFragment() {

    val binding by viewBinding(FragmentTakeAddressPhotoBinding::bind)

    override fun initViews() {
        btnTakePicture = binding.cardTakePictureView
        btnPictureConfirm = binding.tvGoOn
        btnClose = binding.tvAgainTakePhoto
        relLayPictureConfirm = binding.relLayPictureConfirmView
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        addressPreview = binding.addressPreviewView
        imgCapturedImage = binding.imgCapturedImageView
    }

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun getLayoutRes(): Int = R.layout.fragment_take_address_photo

    companion object {
        @JvmStatic
        fun newInstance() =
            TakeAddressPhotoFragment()
    }
}