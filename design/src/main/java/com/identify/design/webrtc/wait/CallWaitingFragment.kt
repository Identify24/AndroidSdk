package com.identify.design.webrtc.wait

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentWaitingCallBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.wait.BaseCallWaitingFragment

class CallWaitingFragment : BaseCallWaitingFragment() {

    val binding by viewBinding(FragmentWaitingCallBinding::bind)



    override fun showCallInformation() {
        this.showInformationDialog(R.raw.customer_sup,null,getString(R.string.call_info_title),getString(R.string.call_info_desc))
    }

    override fun getLayoutRes(): Int = R.layout.fragment_waiting_call

    companion object {

        @JvmStatic
        fun newInstance() =
           CallWaitingFragment()
    }
}