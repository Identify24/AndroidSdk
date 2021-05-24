package com.identify.design.thanks

import com.identify.design.R
import com.identify.design.databinding.FragmentThankYouBinding
import com.identify.sdk.thanks.BaseThankYouFragment

class ThankYouFragment : BaseThankYouFragment<FragmentThankYouBinding>() {





    override fun getLayoutRes(): Int = R.layout.fragment_thank_you

    override fun initViews() {
        cardFinish = binding.cardFinishView
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ThankYouFragment().apply {

            }
    }
}