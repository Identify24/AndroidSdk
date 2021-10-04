package com.identify.design.webrtc.calling


import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentCallingBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.calling.BaseCallingFragment

class CallingFragment : BaseCallingFragment() {

    val binding by viewBinding(FragmentCallingBinding::bind)


    override fun initViews() {
        btnAcceptCall = binding.ibAcceptCallView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getRingMedia(): Int = R.raw.call_ring

    override fun setRingMediaLoop(): Boolean = true

    override fun getLayoutRes(): Int = R.layout.fragment_calling

    companion object {

        @JvmStatic
        fun newInstance() =
            CallingFragment().apply {

            }
    }
}