package com.identify.design.dialogs

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.DialogInformationBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.information.BaseInformationDialogFragment

class InformationDialogFragment : BaseInformationDialogFragment() {


    val binding by viewBinding(DialogInformationBinding::bind)



    override fun setCancelable(): Boolean  = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun getLayoutRes(): Int = R.layout.dialog_information


    override fun initViews() {
        animDetectionStatus = binding.animDetectionStatusView
        imgFrame = binding.imgFrameView
        imgInfo = binding.imgInfoView
        tvInfoContent = binding.tvInfoContentView
        tvInfoTitle = binding.tvInfoTitleView
        btnContinue = binding.cardContinueBtnView
        btnClose = binding.imgCloseBtnView
    }


    companion object {

        @JvmStatic
        fun newInstance(@DrawableRes animResourceId : Int?,@DrawableRes imgResourceId : Int?,infoTitleText : String,infoContentText : String,animRepeatCount : Int = LottieDrawable.INFINITE,isImgFrameVisible: Int = View.GONE) =
            InformationDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("infoContentText",infoContentText)
                    putString("infoTitleText",infoTitleText)
                    putInt("animRepeatCount",animRepeatCount)
                    putInt("isImgFrameVisible",isImgFrameVisible)
                    animResourceId?.let { putInt("animResourceId", it) }
                    imgResourceId?.let { putInt("imgResourceId",it) }
                }
            }
    }

}