package com.identify.design.flowbreak

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.identify.design.R
import com.identify.design.databinding.FragmentExampleFlowBreakBinding
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.IdentifyResultListener
import com.identify.sdk.base.BaseFragment


class FlowBreakFragment : BaseFragment<FragmentExampleFlowBreakBinding>() {

    private var identifyResultListener : IdentifyResultListener?= null

    override fun getLayoutId(): Int = R.layout.fragment_example_flow_break

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