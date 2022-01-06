package com.identify.design.webrtc.wait

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentWaitingCallBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.wait.BaseCallWaitingFragment

class CallWaitingFragment : BaseCallWaitingFragment() {

    val binding by viewBinding(FragmentWaitingCallBinding::bind)

    override fun setQueueMessage(numberOfMember: String, estimatedTime: String) {
        binding.tvQueueView.text = String.format(getString(R.string.estimated_wait),estimatedTime,numberOfMember)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_waiting_call

    override fun changeStatusColor(): Int? = android.R.color.transparent


    companion object {

        @JvmStatic
        fun newInstance() =
           CallWaitingFragment()
    }
}