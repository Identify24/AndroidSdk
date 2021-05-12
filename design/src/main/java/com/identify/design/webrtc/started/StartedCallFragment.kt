package com.identify.design.webrtc.started

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.identify.design.R
import com.identify.design.dialogs.TanBottomDialogFragment
import com.identify.sdk.webrtc.started.BaseStartedCallFragment
import kotlinx.android.synthetic.main.fragment_started_call.*

class StartedCallFragment : BaseStartedCallFragment() {


    override fun getLayoutRes(): Int  = R.layout.fragment_started_call

    override fun initViews() {
        surfaceViewRendererLocal = this.surfaceViewRendererLocalView
        surfaceViewRendererRemote = this.surfaceViewRendererRemoteView
        relLayCallWaiting = this.relLayCallWaitingView
        imgIdCard = this.imgIdCardView
        idLoadingAnimation = this.idLoadingAnimationView
        faceLoadingAnimation = this.faceLoadingAnimationView
    }

    override fun getConnectionErrorMessage(): String = getString(R.string.connection_error_when_calling)

    override fun getTanBottomDialogInstance(tanId : String): BottomSheetDialogFragment = TanBottomDialogFragment.newInstance(tanId)

    override fun setIdGuideFinishedAnimation(): Int = R.raw.nfc_success

    override fun setIdGuideFinishedAnimationRepeatCount(): Int = 0

    override fun setFaceGuideFinishedAnimation(): Int = R.raw.face

    override fun setFaceGuideFinishedAnimationRepeatCount(): Int = 0

    override fun setCanGoBack(): Boolean = false

    override fun errorBackPressed(): String = getString(R.string.identify_is_in_progress)


    companion object {

        @JvmStatic
        fun newInstance() =
            StartedCallFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}