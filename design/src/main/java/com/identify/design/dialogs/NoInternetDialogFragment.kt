package com.identify.design.dialogs

import android.os.Bundle
import com.identify.design.R
import com.identify.design.databinding.DialogNoInternetBinding
import com.identify.sdk.unavaible_internet.ui.BaseNoInternetDialogFragment

class NoInternetDialogFragment  : BaseNoInternetDialogFragment<DialogNoInternetBinding>() {



    override fun getLayoutRes(): Int = R.layout.dialog_no_internet

    override fun initViews() {
        cardTryAgain = binding.cardTryAgainView
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NoInternetDialogFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}