package com.identify.design.dialogs

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.DialogInformationBinding
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.information.BaseInformationDialogFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.repository.model.enums.IdentifyModuleTypes

class InformationDialogFragment : BaseInformationDialogFragment() {


    val binding by viewBinding(DialogInformationBinding::bind)



    override fun setCancelable(): Boolean  = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
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
        cbSignLang = binding.cbSignLangView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent


    companion object {

        @JvmStatic
        fun newInstance(identifyInformationTypes: IdentifyInformationTypes?=null,identifyModuleTypes: IdentifyModuleTypes?=null,@DrawableRes animResourceId : Int?=null,@DrawableRes imgResourceId : Int?=null,infoTitleText : String,infoContentText : String,animRepeatCount : Int = LottieDrawable.INFINITE,isImgFrameVisible: Int = View.GONE) =
            InformationDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("infoContentText",infoContentText)
                    putString("infoTitleText",infoTitleText)
                    putInt("animRepeatCount",animRepeatCount)
                    putString("identifyInformationTypes",identifyInformationTypes?.name)
                    putString("identifyModuleTypes",identifyModuleTypes?.name)
                    putInt("isImgFrameVisible",isImgFrameVisible)
                    animResourceId?.let { putInt("animResourceId", it) }
                    imgResourceId?.let { putInt("imgResourceId",it) }
                }
            }
    }

}