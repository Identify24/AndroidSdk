package com.identify.design.dialogs

import android.os.Bundle
import com.identify.design.R
import com.identify.sdk.unavaible_internet.ui.BaseNoInternetDialogFragment
import kotlinx.android.synthetic.main.dialog_no_internet.*

class NoInternetDialogFragment  : BaseNoInternetDialogFragment() {



    override fun getLayoutRes(): Int = R.layout.dialog_no_internet

    override fun initViews() {
        cardTryAgain = this.cardTryAgainView
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