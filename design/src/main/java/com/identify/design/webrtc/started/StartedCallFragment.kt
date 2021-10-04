package com.identify.design.webrtc.started

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.identify.design.R
import com.identify.design.databinding.FragmentStartedCallBinding
import com.identify.design.dialogs.TanBottomDialogFragment
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.webrtc.started.BaseStartedCallFragment

class StartedCallFragment : BaseStartedCallFragment() {

    val binding by viewBinding(FragmentStartedCallBinding::bind)


    override fun initViews() {
        surfaceViewRendererLocal = binding.surfaceViewRendererLocalView
        surfaceViewRendererRemote = binding.surfaceViewRendererRemoteView
        relLayCallWaiting = binding.relLayCallWaitingView
        imgIdCard = binding.imgIdCardView
        animIdLoading = binding.idLoadingAnimationView
        animFaceLoading = binding.faceLoadingAnimationView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent



    override fun getConnectionErrorMessage(): String = getString(R.string.connection_error_when_calling)

    override fun getTanBottomDialogInstance(tanId : String): BottomSheetDialogFragment = TanBottomDialogFragment.newInstance(tanId)

    override fun setIdGuideFinishedAnimation(): Int = R.raw.nfc_success

    override fun setIdGuideFinishedAnimationRepeatCount(): Int = 0

    override fun setFaceGuideFinishedAnimation(): Int = R.raw.face

    override fun setFaceGuideFinishedAnimationRepeatCount(): Int = 0

    override fun setCanGoBack(): Boolean = false

    override fun errorBackPressed(): String = getString(R.string.identify_is_in_progress)

    override fun getLayoutRes(): Int = R.layout.fragment_started_call



    companion object {

        @JvmStatic
        fun newInstance() =
            StartedCallFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}