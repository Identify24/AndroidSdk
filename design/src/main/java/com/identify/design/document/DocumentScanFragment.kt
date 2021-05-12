package com.identify.design.document


import com.identify.design.R
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.document.BaseDocumentScanFragment
import kotlinx.android.synthetic.main.fragment_document_scanner.*

class DocumentScanFragment : BaseDocumentScanFragment() {



    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }


    override fun getLayoutRes(): Int  = R.layout.fragment_document_scanner

    override fun showIDFrontInformation() {
        this.showInformationDialog(null,R.drawable.kimlikon,getString(R.string.take_photo),getString(R.string.id_card_front_side))
    }

    override fun showIDBackInformation() {
        this.showInformationDialog(null,R.drawable.kimlikarka,getString(R.string.take_photo),getString(R.string.id_card_back_side))
    }


    override fun initViews() {
        cardPictureConfirm = this.cardPictureConfirmView
        cardTakePicture = this.cardTakePictureView
        imgClose = this.imgCloseView
        relLayPictureConfirm = this.relLayPictureConfirmView
        directCallWaiting  = this.directCallWaitingView
        documentPreview  = this.documentPreviewView
        finderBackground = this.finderBackgroundView
        viewFinderWindow = this.viewFinderWindowView
        imgCapturedImage  = this.imgCapturedImageView
    }

    companion object {
        @JvmStatic
        fun  newInstance() = DocumentScanFragment()
    }
}