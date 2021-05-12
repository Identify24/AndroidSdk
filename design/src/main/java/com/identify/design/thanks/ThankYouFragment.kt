package com.identify.design.thanks

import com.identify.design.R
import com.identify.sdk.thanks.BaseThankYouFragment
import kotlinx.android.synthetic.main.fragment_thank_you.*

class ThankYouFragment : BaseThankYouFragment() {





    override fun getLayoutRes(): Int = R.layout.fragment_thank_you

    override fun initViews() {
        cardFinish = this.cardFinishView
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ThankYouFragment().apply {

            }
    }
}