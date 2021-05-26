package com.identify.design.dialogs

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.DialogNoInternetBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.unavaible_internet.ui.BaseNoInternetDialogFragment

class NoInternetDialogFragment  : BaseNoInternetDialogFragment() {

    val binding by viewBinding(DialogNoInternetBinding::bind)


    override fun initViews() {
        cardTryAgain = binding.cardTryAgainView
    }

    override fun getLayoutRes(): Int = R.layout.dialog_no_internet

    companion object {

        @JvmStatic
        fun newInstance() =
            NoInternetDialogFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}