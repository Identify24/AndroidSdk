package com.identify.design.connectionlost


import com.identify.design.R
import com.identify.design.databinding.FragmentConnectionLostBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.connectionlost.BaseConnectionLostFragment

class ConnectionLostFragment : BaseConnectionLostFragment() {

    val binding by viewBinding(FragmentConnectionLostBinding::bind)


    override fun initViews() {
        btnReConnect = binding.cardReConnectView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun plsWaitForConnectionText(): String? = getString(R.string.pls_wait)

    override fun getLayoutRes(): Int = R.layout.fragment_connection_lost


    companion object {
        @JvmStatic
        fun newInstance() =
            ConnectionLostFragment()
    }
}