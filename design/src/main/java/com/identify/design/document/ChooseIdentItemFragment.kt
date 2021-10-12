package com.identify.design.document

import com.identify.design.R
import com.identify.design.databinding.FragmentChooseIdentItemBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseChooseIdentItemFragment

class ChooseIdentItemFragment : BaseChooseIdentItemFragment() {

    val binding by viewBinding(FragmentChooseIdentItemBinding::bind)

    override fun initViews() {
        relLayWithIdCard = binding.relLayWithIdCardView
        relLayWithPassport = binding.relLayWithPassportView
        relLayWithOtherCard = binding.relLayOtherCardView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getLayoutRes(): Int = R.layout.fragment_choose_ident_item

    companion object {

        @JvmStatic
        fun newInstance() =
                ChooseIdentItemFragment()
    }
}