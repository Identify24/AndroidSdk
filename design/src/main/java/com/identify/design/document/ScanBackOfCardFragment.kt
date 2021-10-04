package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentScanBackOfCardBinding
import com.identify.design.databinding.FragmentScanFrontOfCardBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseScanBackOfCardFragment
import kotlinx.android.synthetic.main.fragment_scan_back_of_card.*

class ScanBackOfCardFragment : BaseScanBackOfCardFragment() {

    val binding by viewBinding(FragmentScanBackOfCardBinding::bind)


    override fun initViews() {
        overlay = binding.overlayView
        textOverlay = binding.textOverlayView
        backCardPreview = binding.backCardPreviewView
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun showProgress() {
        this.showProgressDialog()
    }


    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_scan_back_of_card

    companion object {

        @JvmStatic
        fun newInstance() =
                ScanBackOfCardFragment()
    }
}