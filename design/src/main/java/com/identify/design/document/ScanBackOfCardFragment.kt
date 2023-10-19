package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentScanBackOfCardBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseScanBackOfCardFragment

class ScanBackOfCardFragment : BaseScanBackOfCardFragment() {

    val binding by viewBinding(FragmentScanBackOfCardBinding::bind)


    override fun initViews() {
        viewFinder = binding.viewFinder
        progress = binding.progress
        cornerDetector = binding.cornerDetector
        flashToggle = binding.flashToggle
        shutter = binding.shutter
        closeScanner = binding.closeScanner
        rootView = binding.rootView
        holdSteadyLayout = binding.rlHoldSteady
        holdSteadyTv = binding.tvHoldSteady
    }

    override fun getFlashOnSrc(): Int? = R.drawable.ic_flash_on

    override fun getFlashOffSrc(): Int? = R.drawable.ic_flash_off

    override fun getHoldSteadyMessage(): String? = getString(R.string.hold_steady)

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun getLayoutRes(): Int = R.layout.fragment_scan_back_of_card

    companion object {

        @JvmStatic
        fun newInstance() =
                ScanBackOfCardFragment()
    }
}