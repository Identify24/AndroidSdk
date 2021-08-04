package com.identify.design.flowbreak

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentDocumentScannerBinding
import com.identify.design.databinding.FragmentExampleFlowBreakBinding
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.IdentifyNavigationListener
import com.identify.sdk.IdentifyResultListener
import com.identify.sdk.base.BaseFragment
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.flowbreak.BaseFlowBreakFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.repository.model.enums.IdentifyModuleTypes


class FlowBreakFragment : BaseFlowBreakFragment() {

    val binding by viewBinding(FragmentExampleFlowBreakBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    companion object {
        @JvmStatic
        fun  newInstance(identifyInformationTypes: IdentifyInformationTypes?= null) = FlowBreakFragment().apply {
            arguments = Bundle().apply {
                identifyInformationTypes?.let {
                    putString("identifyInformationTypes",it.name)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            // finishInformationFlowBreak() information dialog bitirmek için
            // finishModuleFlowBreak(IdentifyModuleTypes.SPEECH_TEST)  modül bitirmek için
        }

    }





    override fun getLayoutRes(): Int = R.layout.fragment_example_flow_break


}