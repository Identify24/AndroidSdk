package com.identify.design.connectionlost


import com.identify.design.R
import com.identify.design.databinding.FragmentConnectionLostBinding
import com.identify.sdk.connectionlost.BaseConnectionLostFragment

class ConnectionLostFragment : BaseConnectionLostFragment<FragmentConnectionLostBinding>() {


    override fun getLayoutRes(): Int  = R.layout.fragment_connection_lost


    override fun initViews() {
        cardReConnect = binding.cardReConnectView
    }

    override fun plsWaitForConnectionText(): String = getString(R.string.pls_wait)


    companion object {
        @JvmStatic
        fun newInstance() =
            ConnectionLostFragment()
    }
}