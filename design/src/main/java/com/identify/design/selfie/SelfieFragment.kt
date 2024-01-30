package com.identify.design.selfie

import android.view.View
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcModuleBinding
import com.identify.design.databinding.FragmentSelfieBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.information.BaseInformationDialogFragment
import com.identify.sdk.selfie.BaseSelfieFragment
import com.identify.sdk.toasty.Toasty

class SelfieFragment : BaseSelfieFragment(){


    val binding by viewBinding(FragmentSelfieBinding::bind)


    override fun initViews() {
        btnTakePicture = binding.cardTakePictureView
        btnPictureConfirm = binding.tvGoOn
        btnClose = binding.tvAgainTakePhoto
        relLayPictureConfirm = binding.relLayPictureConfirmView
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        selfiePreview = binding.selfiePreviewView
        viewFinderWindow = binding.viewFinderWindowView
        viewFinderBackground = binding.viewFinderBackgroundView
        imgCapturedImage = binding.imgCapturedImageView
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen


    override fun getSelfieComparisonErrorToastMessage(): String? = getString(R.string.selfie_comparison_error)

    override fun getSelfieVerificationFailToastMessage(): String? = getString(R.string.selfie_verification_error)

    override fun errorNoFaceMessage(): String  = getString(R.string.must_have_face)

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

 // onbackpressclicked metodu override edilerek kullanıcı fiziksel geri butonuna bastığında alınacak aksiyonları yönetebilirsiniz.
  /*  override fun onBackPressClicked(click: () -> Unit, disable: Boolean) {
        super.onBackPressClicked({
               Toasty.error(requireContext(),"back pressed",Toasty.LENGTH_SHORT).show()
        },false)
    }*/

    companion object {
        @JvmStatic
        fun newInstance() =
            SelfieFragment()
    }



    override fun getLayoutRes(): Int = R.layout.fragment_selfie
}