package com.identify.design.thanks

import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentThankYouBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.thanks.BaseThankYouFragment

class ThankYouFragment : BaseThankYouFragment() {


    val binding by viewBinding(FragmentThankYouBinding::bind)


    override fun initViews() {
        btnFinish = binding.cardFinishView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getLayoutRes(): Int = R.layout.fragment_thank_you

    companion object {

        @JvmStatic
        fun newInstance() =
            ThankYouFragment().apply {

            }
    }
}