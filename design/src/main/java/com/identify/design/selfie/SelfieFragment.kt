package com.identify.design.selfie

import com.identify.design.R
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.selfie.BaseSelfieFragment
import kotlinx.android.synthetic.main.fragment_selfie.*

class SelfieFragment : BaseSelfieFragment() {



    override fun getLayoutRes(): Int = R.layout.fragment_selfie

    override fun initViews() {
        cardTakePicture = this.cardTakePictureView
        cardPictureConfirm = this.cardPictureConfirmView
        imgClose = this.imgCloseView
        relLayPictureConfirm = this.relLayPictureConfirmView
        directCallWaiting = this.directCallWaitingView
        selfiePreview = this.selfiePreviewView
        viewFinderWindow = this.viewFinderWindowView
        viewFinderBackground = this.viewFinderBackgroundView
        imgCapturedImage = this.imgCapturedImageView
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
}