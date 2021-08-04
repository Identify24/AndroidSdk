package com.identify.design.document


import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentDocumentScannerBinding
import com.identify.design.flowbreak.FlowBreakFragment
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseDocumentScanFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes

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

    // kimlik ön arka fotoğrafı çekilirken arasına tam ekran custom dialog koymak istenilirse kullanılabilir.
    
  /* override fun getCustomIdBackInformationDialogFragment(): DialogFragment? {
        return FlowBreakFragment.newInstance(IdentifyInformationTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO_INFORMATION)
    }*/



    override fun initViews() {
       btnPictureConfirm = binding.cardPictureConfirmView
        btnTakePicture = binding.cardTakePictureView
        btnClose = binding.imgCloseView
        relLayPictureConfirm = binding.relLayPictureConfirmView
        finderBackground = binding.finderBackgroundView
        viewFinderWindow = binding.viewFinderWindowView
        imgCapturedImage  = binding.imgCapturedImageView
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
        documentPreview  = binding.documentPreviewView
    }



    companion object {
        @JvmStatic
        fun  newInstance() = DocumentScanFragment()
    }

    // bu modül bittiğinde diğer modüle geçmeden arada bir ekran göstermek istenilirse kullanılabilir.
    
 /*   override fun takeCardPhotoModuleFinished() {
         (activity as BaseIdentifyActivity<*>).showFragment(FlowBreakFragment.newInstance(),FlowBreakFragment::class.java.toString())
    }*/

    override fun getLayoutRes(): Int = R.layout.fragment_document_scanner
}