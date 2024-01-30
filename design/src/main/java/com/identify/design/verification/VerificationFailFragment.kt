package com.identify.design.verification

import com.identify.design.R
import com.identify.design.databinding.FragmentVerificationFailBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.verification.BaseVerificationFailFragment

class VerificationFailFragment : BaseVerificationFailFragment() {


    val binding by viewBinding(FragmentVerificationFailBinding::bind)


    override fun initViews() {
        btnFinish = binding.cardFinishView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getLayoutRes(): Int = R.layout.fragment_verification_fail

    companion object {

        @JvmStatic
        fun newInstance() =
            VerificationFailFragment().apply {

            }
    }
}