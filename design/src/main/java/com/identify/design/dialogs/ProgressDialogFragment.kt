package com.identify.design.dialogs

import com.identify.design.R
import com.identify.sdk.dialogs.BaseProgressDialogFragment

class ProgressDialogFragment : BaseProgressDialogFragment() {




    companion object {

        @JvmStatic
        fun  newInstance() = ProgressDialogFragment()


    }

    override fun getLayoutRes(): Int = R.layout.progress_view


}