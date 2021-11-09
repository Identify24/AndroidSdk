package com.identify.design.address

import com.identify.design.R
import com.identify.design.databinding.FragmentEnterAddressBinding
import com.identify.design.util.hideProgressDialog
import com.identify.design.util.showProgressDialog
import com.identify.sdk.address.BaseEnterAddressFragment
import com.identify.sdk.base.viewBinding.viewBinding

class EnterAddressFragment : BaseEnterAddressFragment() {

    val binding by viewBinding(FragmentEnterAddressBinding::bind)


    override fun initViews() {
         btnConfirmAddress = binding.cardConfirmAddressView
         edtAddress = binding.edtAddressView
         btnGoTakePhoto  = binding.cardTakePhotoView
         imgProofPhoto = binding.imgProofPhotoView
         imgClose = binding.imgCloseView
         btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
    }

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun showProgress() {
        this.showProgressDialog()
    }

    override fun hideProgress() {
        this.hideProgressDialog()
    }

    override fun getAddressErrorMessage(): String = getString(R.string.address_title)

    override fun getLayoutRes(): Int = R.layout.fragment_enter_address

    companion object {
        @JvmStatic
        fun newInstance() =
            EnterAddressFragment()
    }

}