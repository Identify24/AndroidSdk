package com.identify.design.dialogs

import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentBottomTanBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.started.BaseTanBottomDialogFragment

class TanBottomDialogFragment : BaseTanBottomDialogFragment() {

    val binding by viewBinding(FragmentBottomTanBinding::bind)


    override fun initViews() {
        pin1 = binding.etPin1
        pin2 = binding.etPin2
        pin3 = binding.etPin3
        pin4 = binding.etPin4
        pin5 = binding.etPin5
        pin6 = binding.etPin6
        btnSend = binding.cardSendBtnView
        progressCircular = binding.progressCircularView
    }

    override fun errorTanLength(): String = getString(R.string.enter_pin)

    override fun startFocusEditText(edt: EditText) {
        edt.alpha = 1f
        edt.background = ContextCompat.getDrawable(requireContext(), R.drawable.all_yellow_border_white_bg)
    }

    override fun finishFocusEditText(edt: EditText) {
        edt.alpha = 0.5f
        edt.background = ContextCompat.getDrawable(requireContext(), R.drawable.all_grey_border_white_bg)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_bottom_tan


    companion object {

        @JvmStatic
        fun newInstance(tanId : String) =
            TanBottomDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("tanId",tanId)
                }
            }
    }
}