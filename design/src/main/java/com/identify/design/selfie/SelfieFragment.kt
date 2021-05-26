package com.identify.design.selfie

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcModuleBinding
import com.identify.design.databinding.FragmentSelfieBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.selfie.BaseSelfieFragment

class SelfieFragment : BaseSelfieFragment() {


    val binding by viewBinding(FragmentSelfieBinding::bind)


    override fun initViews() {
        cardTakePicture = binding.cardTakePictureView
        cardPictureConfirm = binding.cardPictureConfirmView
        imgClose = binding.imgCloseView
        relLayPictureConfirm = binding.relLayPictureConfirmView
        directCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        selfiePreview = binding.selfiePreviewView
        viewFinderWindow = binding.viewFinderWindowView
        viewFinderBackground = binding.viewFinderBackgroundView
        imgCapturedImage = binding.imgCapturedImageView
    }

    override fun showSelfieInformation() {
        this.showInformationDialog( R.raw.selfie,null, getString(R.string.take_photo), getString(R.string.pls_take_selfie))
    }

    override fun errorNoFaceMessage(): String  = getString(R.string.must_have_face)

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SelfieFragment()
    }


    override fun takeSelfieModuleFinished() {
        finish()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_selfie
}