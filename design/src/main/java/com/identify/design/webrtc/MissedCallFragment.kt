package com.identify.design.webrtc

import com.identify.design.R
import com.identify.design.databinding.FragmentMissedCallBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.missed.BaseMissedCallFragment

class MissedCallFragment : BaseMissedCallFragment() {

    val binding by viewBinding(FragmentMissedCallBinding::bind)

    override fun initViews() {
        btnOK = binding.btnOK
    }

    override fun getLayoutRes(): Int = R.layout.fragment_missed_call

    companion object {

        @JvmStatic
        fun newInstance() =
            MissedCallFragment().apply {

            }
    }
}