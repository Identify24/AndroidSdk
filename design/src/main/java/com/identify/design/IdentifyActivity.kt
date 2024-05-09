package com.identify.design

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.identify.design.address.ValidateAddressModule
import com.identify.design.connectionlost.ConnectionLostFragment
import com.identify.design.databinding.ActivityIdentifyBinding
import com.identify.design.document.CardScanModuleFragment
import com.identify.design.intro.IntroFragment
import com.identify.design.liveness.LivenessDetectionModuleFragment
import com.identify.design.nfc.NfcModuleFragment
import com.identify.design.permission.PermissionFragment
import com.identify.design.prepare.PrepareModuleFragment
import com.identify.design.selfie.SelfieModuleFragment
import com.identify.design.signature.SignatureModuleFragment
import com.identify.design.speech.SpeechModuleFragment
import com.identify.design.thanks.ThankYouFragment
import com.identify.design.util.alert
import com.identify.design.verification.VerificationFailFragment
import com.identify.design.video.VideoRecordModuleFragment
import com.identify.design.webrtc.CallModuleFragment
import com.identify.sdk.BaseIdentifyActivity


class IdentifyActivity : BaseIdentifyActivity<ActivityIdentifyBinding>() {


    override fun getConnectionLostFragmentInstance(): Fragment? = ConnectionLostFragment.newInstance()

    override fun getCardScanModuleFragmentInstance(): Fragment? = CardScanModuleFragment.newInstance()

    override fun getSpeechModuleFragmentInstance(): Fragment? = SpeechModuleFragment.newInstance()

    override fun getSelfieModuleFragmentInstance(): Fragment? = SelfieModuleFragment.newInstance()
    override fun getPrepareModuleFragmentInstance(): Fragment? = PrepareModuleFragment.newInstance()

    override fun getValidateAddressModuleFragmentInstance(): Fragment?  = ValidateAddressModule.newInstance()

    override fun getLivenessDetectionModuleFragmentInstance(): Fragment? = LivenessDetectionModuleFragment.newInstance()

    override fun getNfcModuleFragmentInstance(): Fragment? = NfcModuleFragment.newInstance()

    override fun getCallModuleFragmentInstance(isRedirect: Boolean): Fragment? = CallModuleFragment.newInstance(isRedirect)

    override fun getIntroFragmentInstance(): Fragment? = IntroFragment.newInstance()

    override fun getVerificationFailFragmentInstance(): Fragment? = VerificationFailFragment.newInstance()

    override fun getThankYouFragmentInstance(): Fragment? = ThankYouFragment.newInstance()

    override fun getVideoRecordModuleFragmentInstance(): Fragment? = VideoRecordModuleFragment.newInstance()

    override fun getSignatureModuleFragmentInstance(): Fragment? = SignatureModuleFragment.newInstance()

    override fun getPermissionFragmentInstance(): Fragment? = PermissionFragment.newInstance()


    override fun getFragmentContainerId(): Int = R.id.fragmentContainerView

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

    override fun getIdentSubRejectedMessage(): String = getString(R.string.reason_subrejected)


    override fun getLayoutId(): Int = R.layout.activity_identify

    override fun initViews() {
        fragmentContainer = binding.fragmentContainerView
        progressCircular = binding.progressCircularView
    }



    override fun getViewBinding(): ActivityIdentifyBinding = ActivityIdentifyBinding.inflate(layoutInflater)

}