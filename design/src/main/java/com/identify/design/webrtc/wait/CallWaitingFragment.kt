package com.identify.design.webrtc.wait

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentWaitingCallBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.wait.BaseCallWaitingFragment

class CallWaitingFragment : BaseCallWaitingFragment() {

    val binding by viewBinding(FragmentWaitingCallBinding::bind)

    override fun initViews() {
        tvQueue = binding.tvQueueView
    }

    override fun getQueueMessage(): String = getString(R.string.estimated_wait)

    override fun getQueueFinishedMessage(): String = getString(R.string.agent_ready)

    override fun getLayoutRes(): Int = R.layout.fragment_waiting_call

    override fun changeStatusColor(): Int? = android.R.color.transparent


    companion object {

        @JvmStatic
        fun newInstance() =
           CallWaitingFragment()
    }
}