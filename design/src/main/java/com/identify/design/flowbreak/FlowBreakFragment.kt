package com.identify.design.flowbreak


import android.os.Bundle
import android.view.View
import com.identify.design.R
import com.identify.design.databinding.FragmentExampleFlowBreakBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.flowbreak.BaseFlowBreakFragment
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes


class FlowBreakFragment : BaseFlowBreakFragment() {

    val binding by viewBinding(FragmentExampleFlowBreakBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    companion object {
        @JvmStatic
        fun  newInstance(identifyInformationTypes: IdentifyInformationTypes) = FlowBreakFragment().apply {
            arguments = Bundle().apply {
                identifyInformationTypes.let {
                    putString("identifyInformationTypes",it.name)
                }
            }
        }
    }

    override fun initView() {
        // işaret dili temsilcisi seçilen checkbox viewin referansı için kullanılabilir
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