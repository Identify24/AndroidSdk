package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentScanFrontOfCardBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.isProgressShowing
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseScanFrontOfCardFragment

class ScanFrontOfCardFragment : BaseScanFrontOfCardFragment() {

    val binding by viewBinding(FragmentScanFrontOfCardBinding::bind)


    override fun initViews() {
        overlay = binding.overlayView
        textOverlay = binding.textOverlayView
        frontCardPreview = binding.frontCardPreviewView
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_scan_front_of_card


    companion object {

        @JvmStatic
        fun newInstance() =
                ScanFrontOfCardFragment()
    }

}