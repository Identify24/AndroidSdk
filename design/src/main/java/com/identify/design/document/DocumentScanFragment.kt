package com.identify.design.document


import com.identify.design.R
import com.identify.design.databinding.FragmentDocumentScannerBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.document.BaseDocumentScanFragment

class DocumentScanFragment : BaseDocumentScanFragment<FragmentDocumentScannerBinding>() {



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
        cardPictureConfirm = binding.cardPictureConfirmView
        cardTakePicture = binding.cardTakePictureView
        imgClose = binding.imgCloseView
        relLayPictureConfirm = binding.relLayPictureConfirmView
        directCallWaiting  = binding.directCallWaitingView
        documentPreview  = binding.documentPreviewView
        finderBackground = binding.finderBackgroundView
        viewFinderWindow = binding.viewFinderWindowView
        imgCapturedImage  = binding.imgCapturedImageView
    }



    companion object {
        @JvmStatic
        fun  newInstance() = DocumentScanFragment()
    }

    override fun takeCardPhotoModuleFinished() {
        finish()
        // or (activity as BaseIdentifyActivity).showFragment(FlowBreakFragment.newInstance(),FlowBreakFragment::class.java.toString())
    }
}