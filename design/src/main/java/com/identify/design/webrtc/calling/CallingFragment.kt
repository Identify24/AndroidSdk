package com.identify.design.webrtc.calling


import com.identify.design.R
import com.identify.design.databinding.FragmentCallingBinding
import com.identify.sdk.webrtc.calling.BaseCallingFragment

class CallingFragment : BaseCallingFragment<FragmentCallingBinding>() {


    override fun getLayoutRes(): Int = R.layout.fragment_calling

    override fun initViews() {
       ibAcceptCall = binding.ibAcceptCallView
    }

    override fun getRingMedia(): Int = R.raw.call_ring

    override fun setRingMediaLoop(): Boolean = true

    companion object {

        @JvmStatic
        fun newInstance() =
            CallingFragment().apply {

            }
    }
}