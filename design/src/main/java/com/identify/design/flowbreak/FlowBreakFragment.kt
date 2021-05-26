package com.identify.design.flowbreak

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentDocumentScannerBinding
import com.identify.design.databinding.FragmentExampleFlowBreakBinding
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.IdentifyResultListener
import com.identify.sdk.base.BaseFragment
import com.identify.sdk.base.viewBinding.viewBinding


class FlowBreakFragment : BaseFragment() {

    val binding by viewBinding(FragmentExampleFlowBreakBinding::bind)

    private var identifyResultListener : IdentifyResultListener?= null


    companion object {
        @JvmStatic
        fun  newInstance() = FlowBreakFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            identifyResultListener?.takeCardPhotoProcessFinished()
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as BaseIdentifyActivity<*>).changeStatusBarColor(ContextCompat.getColor(requireContext(),R.color.red))
    }

    override fun getLayoutRes(): Int = R.layout.fragment_example_flow_break

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is BaseIdentifyActivity<*>) {
            identifyResultListener = activity as IdentifyResultListener
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        identifyResultListener = null
    }
}