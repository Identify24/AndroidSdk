package com.identify.design.webrtc.wait

import com.identify.design.R
import com.identify.design.databinding.FragmentWaitingCallBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.webrtc.wait.BaseCallWaitingFragment

class CallWaitingFragment : BaseCallWaitingFragment<FragmentWaitingCallBinding>() {



    override fun getLayoutRes(): Int = R.layout.fragment_waiting_call


    override fun showCallInformation() {
        this.showInformationDialog(R.raw.customer_sup,null,getString(R.string.call_info_title),getString(R.string.call_info_desc))
    }

    companion object {

        @JvmStatic
        fun newInstance() =
           CallWaitingFragment()
    }
}