package com.identify.design

import android.content.Intent
import android.provider.Settings
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.identify.design.connectionlost.ConnectionLostFragment
import com.identify.design.databinding.ActivityIdentifyBinding
import com.identify.design.databinding.FragmentCallModuleBinding
import com.identify.design.dialogs.NoInternetDialogFragment
import com.identify.design.document.DocumentScanFragment
import com.identify.design.intro.IntroFragment
import com.identify.design.liveness.LivenessDetectionFragment
import com.identify.design.nfc.NfcModuleFragment
import com.identify.design.selfie.SelfieFragment
import com.identify.design.signature.SignatureFragment
import com.identify.design.speech.SpeechFragment
import com.identify.design.thanks.ThankYouFragment
import com.identify.design.util.alert
import com.identify.design.video.VideoRecordFragment
import com.identify.design.webrtc.CallModuleFragment
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.base.viewBinding.viewBinding
import permissions.dispatcher.PermissionRequest

class IdentifyActivity : BaseIdentifyActivity<ActivityIdentifyBinding>() {


    override fun getConnectionLostFragmentInstance(): Fragment = ConnectionLostFragment.newInstance()

    override fun getDocumentScanFragmentInstance(): Fragment = DocumentScanFragment.newInstance()

    override fun getSpeechFragmentInstance(): Fragment = SpeechFragment.newInstance()

    override fun getSelfieFragmentInstance(): Fragment = SelfieFragment.newInstance()

    override fun getLivenessDetectionFragmentInstance(): Fragment = LivenessDetectionFragment.newInstance()

    override fun getNfcModuleFragmentInstance(): Fragment = NfcModuleFragment.newInstance()

    override fun getCallModuleFragmentInstance(isRedirect: Boolean): Fragment = CallModuleFragment.newInstance(isRedirect)

    override fun getIntroFragmentInstance(): Fragment = IntroFragment.newInstance()

    override fun getThankYouFragmentInstance(): Fragment = ThankYouFragment.newInstance()

    override fun getVideoRecordFragmentInstance(): Fragment = VideoRecordFragment.newInstance()

    override fun getSignatureFragmentInstance(): Fragment = SignatureFragment.newInstance()

    override fun getNoInternetDialogInstance(): DialogFragment = NoInternetDialogFragment.newInstance()

    override fun getFragmentContainerId(): Int = R.id.fragmentContainerView

    override fun getStatusBarColor(): Int = R.color.colorGreen

    override fun ifNfcIsCloseShowDialog() {
        alert(false, getString(R.string.go_to_setting), null, getString(R.string.nfc_off), getString(R.string.nfc_off_desc), { dialog ->
            startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
            dialog.dismiss()
        }, {}, {})
    }

    override fun showRationaleDialog(request: PermissionRequest) {
        alert(false, getString(R.string.button_allow), getString(R.string.button_deny), null, getString(R.string.permission_camera_rationale), { dialog ->
            request.proceed()
            dialog.dismiss()
        }, { dialog ->
            request.cancel()
            dialog.dismiss()
        }, {})

    }

    override fun getAuthenticationErrorMessage(): String  = getString(R.string.reason_authentication_error)

    override fun getResponseErrorMessage(): String = getString(R.string.reason_response)

    override fun getTimeoutErrorMessage(): String = getString(R.string.reason_timeout)

    override fun getSocketConnectionErrorMessage(): String = getString(R.string.reason_socket_connection)

    override fun getUiViewErrorMessage(): String = getString(R.string.reason_generic)


    override fun getLayoutId(): Int = R.layout.activity_identify

    override fun initViews() {
        fragmentContainer = binding.fragmentContainerView
    }


    override fun getViewBinding(): ActivityIdentifyBinding = ActivityIdentifyBinding.inflate(layoutInflater)

}