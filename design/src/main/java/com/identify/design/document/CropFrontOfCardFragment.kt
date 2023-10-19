package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentCropperBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseCropFrontOfCardFragment

class CropFrontOfCardFragment: BaseCropFrontOfCardFragment() {

    val binding by viewBinding(FragmentCropperBinding::bind)

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun initViews() {
        cropPreview = binding.cropPreview
        cropWrap = binding.cropWrap
        cropCornerDetector = binding.cropCornerDetector
        cropResultPreview = binding.cropResultPreview
        closeResultPreview = binding.closeResultPreview
        closeCropPreview = binding.closeCropPreview
        confirmCropPreview = binding.confirmCropPreview
        polygonView = binding.polygonView
        sourceFrame = binding.sourceFrame
        cropResultWrap = binding.cropResultWrap
        confirmCropResult = binding.tvGoOn
        takePhotoAgain = binding.tvAgainTakePhoto
        cropRootView = binding.cropRootView
        rotateImage = binding.rotateImage
    }

    override fun getCropErrorMessage(): String? = getString(R.string.crop_error)

    override fun getIdCouldNotDetectedErrorMessage(): String? = getString(R.string.id_not_detected)

    override fun getInvalidFrontOfIdMessage(): String? = getString(R.string.invalid_front_id)

    override fun getCapturingConditionsErrorMessage(): String? = getString(R.string.capturing_conditions_error)
    override fun getLayoutRes(): Int = R.layout.fragment_cropper


    companion object {

        @JvmStatic
        fun newInstance() =
            CropFrontOfCardFragment()
    }
}