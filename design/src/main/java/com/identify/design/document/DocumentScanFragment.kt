package com.identify.design.document


import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentDocumentScannerBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseDocumentScanFragment

class DocumentScanFragment : BaseDocumentScanFragment() {

    val binding by viewBinding(FragmentDocumentScannerBinding::bind)


    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }


    override fun showIDFrontInformation() {
        this.showInformationDialog(null,R.drawable.kimlikon,getString(R.string.take_photo),getString(R.string.id_card_front_side))
    }

    override fun showIDBackInformation() {
        this.showInformationDialog(null,R.drawable.kimlikarka,getString(R.string.take_photo),getString(R.string.id_card_back_side))
    }


    override fun initViews() {
        btnPictureConfirm = binding.cardPictureConfirmView
        btnTakePicture = binding.cardTakePictureView
        btnClose = binding.imgCloseView
        relLayPictureConfirm = binding.relLayPictureConfirmView
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
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

    override fun getLayoutRes(): Int = R.layout.fragment_document_scanner
}