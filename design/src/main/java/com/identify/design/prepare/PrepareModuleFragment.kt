package com.identify.design.prepare

import com.identify.design.R
import com.identify.sdk.prepare.BasePrepareModuleFragment

class PrepareModuleFragment : BasePrepareModuleFragment() {

    override fun getPrepareFragmentInstance() = PrepareFragment.newInstance()

    override fun getFragmentContainer() = R.id.prepareContainer

    override fun getLayoutRes() = R.layout.fragment_prepare_module

    companion object {

        @JvmStatic
        fun newInstance() = PrepareModuleFragment()
    }
}