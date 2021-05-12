package com.identify.design.webrtc.calling


import com.identify.design.R
import com.identify.sdk.webrtc.calling.BaseCallingFragment
import kotlinx.android.synthetic.main.fragment_calling.*

class CallingFragment : BaseCallingFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_calling

    override fun initViews() {
       ibAcceptCall = this.ibAcceptCallView
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