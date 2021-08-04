package com.identify.design.dialogs

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.ProgressViewBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.dialogs.BaseProgressDialogFragment

class ProgressDialogFragment : BaseProgressDialogFragment() {


    val binding by viewBinding(ProgressViewBinding::bind)

    companion object {

        @JvmStatic
        fun  newInstance() = ProgressDialogFragment()
    }


    override fun getLayoutRes(): Int = R.layout.progress_view


}