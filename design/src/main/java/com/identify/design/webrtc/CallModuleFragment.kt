package com.identify.design.webrtc

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentCallModuleBinding
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.design.thanks.ThankYouFragment
import com.identify.design.webrtc.calling.CallingFragment
import com.identify.design.webrtc.started.StartedCallFragment
import com.identify.design.webrtc.wait.CallWaitingFragment
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.webrtc.BaseCallModuleFragment

class CallModuleFragment : BaseCallModuleFragment() {


    val binding by viewBinding(FragmentCallModuleBinding::bind)


    override fun getCallWaitingFragmentInstance() : Fragment = CallWaitingFragment.newInstance()

    override fun getStartedCallFragmentInstance()  : Fragment = StartedCallFragment.newInstance()

    override fun getCallingFragmentInstance() : Fragment = CallingFragment.newInstance()

    override fun getCallInformationFragment(): Fragment?  = InformationDialogFragment.newInstance(IdentifyInformationTypes.AGENT_CALL_INFORMATION,animResourceId = R.raw.customer_sup,infoTitleText = getString(R.string.call_info_title),infoContentText = getString(R.string.call_info_desc))

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

    override fun callModuleFinished(withRedirect: Boolean) {
        finish(withRedirect)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_call_module
}