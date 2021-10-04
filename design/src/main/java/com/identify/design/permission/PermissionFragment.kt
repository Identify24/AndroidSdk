package com.identify.design.permission

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.identify.design.R
import com.identify.design.databinding.FragmentPermissionBinding
import com.identify.design.util.alert
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.permission.BasePermissionFragment
import permissions.dispatcher.PermissionRequest

class PermissionFragment : BasePermissionFragment() {

    val binding by viewBinding(FragmentPermissionBinding::bind)


    override fun initViews() {
        btnAllowPermission = binding.btnAllowPermissionView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getPermissionDeniedToastMessage(): String? = null

    override fun showRationaleDialog(request: PermissionRequest) {
        requireContext().alert(false, getString(R.string.button_allow), getString(R.string.button_deny), null, getString(R.string.permission_camera_rationale), { dialog ->
            request.proceed()
            dialog.dismiss()
        }, { dialog ->
            request.cancel()
            dialog.dismiss()
        }, {})

    }



    override fun getLayoutRes(): Int  = R.layout.fragment_permission

    companion object {

        @JvmStatic
        fun newInstance() =
                PermissionFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}