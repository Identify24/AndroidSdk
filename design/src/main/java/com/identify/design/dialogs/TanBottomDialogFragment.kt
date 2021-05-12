package com.identify.design.dialogs

import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.identify.design.R
import com.identify.sdk.webrtc.started.BaseTanBottomDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_tan.*

class TanBottomDialogFragment : BaseTanBottomDialogFragment() {


    override fun getLayoutRes(): Int = R.layout.fragment_bottom_tan

    override fun initViews() {
        pin1 = this.etPin1
        pin2 = this.etPin2
        pin3 = this.etPin3
        pin4 = this.etPin4
        pin5 = this.etPin5
        pin6 = this.etPin6
        cardSendBtn = this.cardSendBtnView
        progressCircular = this.progressCircularView
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