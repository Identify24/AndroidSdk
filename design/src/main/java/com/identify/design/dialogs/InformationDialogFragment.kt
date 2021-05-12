package com.identify.design.dialogs

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.sdk.information.BaseInformationDialogFragment
import kotlinx.android.synthetic.main.dialog_information.*

class InformationDialogFragment : BaseInformationDialogFragment() {





    override fun getLayoutRes(): Int  = R.layout.dialog_information


    override fun setCancelable(): Boolean  = false


    override fun initViews() {
        animDetectionStatus = this.animDetectionStatusView
        imgFrame = this.imgFrameView
        imgInfo = this.imgInfoView
        tvInfoContent = this.tvInfoContentView
        tvInfoTitle = this.tvInfoTitleView
        cardContinueBtn = this.cardContinueBtnView
        imgCloseBtn = this.imgCloseBtnView
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