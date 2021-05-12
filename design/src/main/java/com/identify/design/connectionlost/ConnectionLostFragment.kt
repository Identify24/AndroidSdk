package com.identify.design.connectionlost


import com.identify.design.R
import com.identify.sdk.connectionlost.BaseConnectionLostFragment
import kotlinx.android.synthetic.main.fragment_connection_lost.*

class ConnectionLostFragment : BaseConnectionLostFragment() {


    override fun getLayoutRes(): Int  = R.layout.fragment_connection_lost


    override fun initViews() {
        cardReConnect = this.cardReConnectView
    }

    override fun plsWaitForConnectionText(): String = getString(R.string.pls_wait)


    companion object {
        @JvmStatic
        fun newInstance() =
            ConnectionLostFragment()
    }
}