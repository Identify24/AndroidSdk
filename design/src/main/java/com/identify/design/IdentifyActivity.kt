package com.identify.design

import android.content.Intent
import android.provider.Settings
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.identify.design.connectionlost.ConnectionLostFragment
import com.identify.design.databinding.ActivityIdentifyBinding
import com.identify.design.dialogs.NoInternetDialogFragment
import com.identify.design.document.DocumentScanFragment
import com.identify.design.flowbreak.FlowBreakFragment
import com.identify.design.intro.IntroFragment
import com.identify.design.liveness.LivenessDetectionFragment
import com.identify.design.nfc.NfcModuleFragment
import com.identify.design.permission.PermissionFragment
import com.identify.design.selfie.SelfieFragment
import com.identify.design.signature.SignatureFragment
import com.identify.design.speech.SpeechFragment
import com.identify.design.thanks.ThankYouFragment
import com.identify.design.util.alert
import com.identify.design.video.VideoRecordFragment
import com.identify.design.webrtc.CallModuleFragment
import com.identify.sdk.BaseIdentifyActivity
import com.identify.sdk.repository.model.enums.IdentifyInformationTypes
import com.identify.sdk.repository.model.enums.IdentifyModuleTypes


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

    override fun getAuthenticationErrorMessage(): String  = getString(R.string.reason_authentication_error)

    override fun getResponseErrorMessage(): String = getString(R.string.reason_response)

    override fun getTimeoutErrorMessage(): String = getString(R.string.reason_timeout)

    override fun getSocketConnectionErrorMessage(): String = getString(R.string.reason_socket_connection)

    override fun getUiViewErrorMessage(): String = getString(R.string.reason_generic)


    override fun getLayoutId(): Int = R.layout.activity_identify

    override fun initViews() {
        fragmentContainer = binding.fragmentContainerView
        progressCircular = binding.progressCircularView
    }


    // modüllerin başına custom information getirmek isterseniz modülleri açtığınız sırada bir information listesi vermeniz gerekli.
    //eğer bir modülün başında açmak istemiyosanız o modül için null vermeniz yeterli
  /*  override fun getInformationFragmentList(): List<Fragment?>? {
        return listOf(
                FlowBreakFragment.newInstance(IdentifyInformationTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.IDENTIFICATION_INFORMATION_WITH_NFC_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.TAKE_SELFIE_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.VITALITY_TEST_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.SPEECH_TEST_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.VIDEO_RECORD_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.DIJITAL_SIGNATURE_INFORMATION),
                FlowBreakFragment.newInstance(IdentifyInformationTypes.AGENT_CALL_INFORMATION))
    }*/





    override fun getViewBinding(): ActivityIdentifyBinding = ActivityIdentifyBinding.inflate(layoutInflater)

    override fun getPermissionFragmentInstance(): Fragment = PermissionFragment.newInstance()

}