package com.identify.design.prepare

import android.os.Bundle
import com.identify.design.R
import com.identify.design.databinding.FragmentPrepareBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.prepare.BasePrepareFragment

class PrepareFragment : BasePrepareFragment() {

    val binding by viewBinding(FragmentPrepareBinding::bind)

    override fun getUnsuitableInternetErrorMessage(): String =getString(R.string.unsuitable_internet)

    override fun initViews() {
        cbIdNear = binding.cbIdNear
        cbIamAlone = binding.cbIamAlone
        cbPlaceState = binding.cbPlaceState
        cbConnectionStatus = binding.cbConnectionFine
        btnContinue = binding.btnConfirm
        ivTestAgain = binding.ivDownloadTestAgain
    }

    override fun getLayoutRes() = R.layout.fragment_prepare

    companion object {

        @JvmStatic
        fun newInstance() =
            PrepareFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}