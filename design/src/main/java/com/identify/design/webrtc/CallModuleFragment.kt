package com.identify.design.webrtc

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.identify.design.R
import com.identify.design.thanks.ThankYouFragment
import com.identify.design.webrtc.calling.CallingFragment
import com.identify.design.webrtc.started.StartedCallFragment
import com.identify.design.webrtc.wait.CallWaitingFragment
import com.identify.sdk.webrtc.BaseCallModuleFragment

class CallModuleFragment : BaseCallModuleFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_call_module

    override fun getCallWaitingFragmentInstance() : Fragment = CallWaitingFragment.newInstance()

    override fun getStartedCallFragmentInstance()  : Fragment = StartedCallFragment.newInstance()

    override fun getCallingFragmentInstance() : Fragment = CallingFragment.newInstance()

    override fun getThankYouFragmentInstance() : Fragment = ThankYouFragment.newInstance()

    override fun getFragmentContainer(): Int = R.id.callFragmentContainer


    companion object {

        @JvmStatic
        fun newInstance(isRedirect : Boolean) =
            CallModuleFragment().apply {
                arguments = Bundle().apply {
                    putBoolean("isRedirect",isRedirect)
                }
            }
    }
}