package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentScanPassportBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showInformationDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseScanPassportFragment


class ScanPassportFragment : BaseScanPassportFragment() {

    val binding by viewBinding(FragmentScanPassportBinding::bind)

    companion object {

        @JvmStatic
        fun newInstance() =
                ScanPassportFragment()
    }


    override fun showProgress() {
        this.showProgressDialog()
    }


    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun getAmbientLightPercent(percent: Int?) {
        percent?.let {
            binding.tvLightPercentView.text = "%$percent"
        }
    }

    override fun initViews() {
        passportPreview = binding.passportPreview
        overlay = binding.overlay
        textOverlay = binding.textOverlay
        btnDirectCallWaiting  = binding.directCallWaitingView.cardDirectCallWaiting
        tvLightPercent = binding.tvLightPercentView
        imgLight = binding.imgLightView
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen


    override fun showOcrForPassportInformation() {
        this.showInformationDialog(null, R.drawable.img_passport, getString(R.string.mrz_info_title), getString(R.string.ocr_info_desc_passport))
    }



    override fun getLayoutRes(): Int = R.layout.fragment_scan_passport
}