package com.identify.design.nfc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.airbnb.lottie.LottieDrawable
import com.identify.design.R
import com.identify.design.databinding.FragmentNfcBinding
import com.identify.design.util.alert
import com.identify.sdk.ApiResponseStatusListener
import com.identify.sdk.base.*
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.BaseNfcFragment
import com.identify.sdk.mrz.NfcApiListener
import com.identify.sdk.mrz.NfcStatusListener
import com.identify.sdk.repository.model.dto.MrzDto
import com.identify.sdk.scanner.State
import com.identify.sdk.toasty.Toasty

class NfcFragment : BaseNfcFragment() {

    val binding by viewBinding(FragmentNfcBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.directCallWaitingView.cardDirectCallWaiting.setOnClickListener {
            goDirectCallWaiting()
        }

        binding.cardNextView.setOnClickListener {
            finishNfcModule()
        }

        listenNfcStatus(object : NfcStatusListener{
            override fun onStart() {

                binding.relLayDefaultNfcView.visibility = View.GONE
                binding.linLayReadNfcView.visibility = View.VISIBLE
                binding.tvNfcStatusView.text = getNfcReadingText()
                binding.nfcAnimationView.setAnimation(setReadingNfcAnimation())
                binding.nfcAnimationView.repeatCount = setReadingNfcAnimationRepeatCount()
                binding.nfcAnimationView.playAnimation()
            }

            override fun onSuccess(nfcData: MrzDto) {

                sendNfcData(nfcData, object : NfcApiListener {
                    override fun onSuccess(status: Boolean) {
                        when(status){
                            true-> {
                                binding.cardNextView.visibility = View.VISIBLE
                                binding.nfcAnimationView.setAnimation(setNfcSuccessFinishedAnimation())
                                binding.tvNfcStatusView.text = getNfcSuccessText()
                            }
                            false -> {

                                binding.cardNextView.visibility = View.GONE
                                binding.nfcAnimationView.setAnimation(setNfcFailFinishedAnimation())
                                binding.tvNfcStatusView.text = getNfcTryAgainText()
                            }
                        }
                        binding.nfcAnimationView.repeatCount = setNfcReadingFinishedAnimationRepeatCount()
                        binding.nfcAnimationView.playAnimation()
                    }

                    override fun onFailure(reason: Reason) {

                        when(reason){
                            is ResponseError -> {
                                nfcFailProcess()
                                getNfcFailToastMessage().let {
                                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                                }
                            }
                            is ApiError -> {
                                nfcFailProcess()
                                getNfcFailToastMessage().let {
                                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                                }
                            }

                            is ApiComparisonError -> {
                                if(getNfcComparisonCount() != 0) {
                                    getNfcComparisonErrorToastMessage().let { it1 -> Toasty.error(requireContext(), it1,Toasty.LENGTH_LONG).show() }
                                    declareNfcComparisonCount()
                                    nfcFailProcess()
                                    goCardPhotoModule()
                                } else {
                                    getNfcVerificationFailToastMessage().let { it1 -> Toasty.error(requireContext(), it1,Toasty.LENGTH_LONG).show() }
                                    nfcFailProcess()
                                    goVerificationFailPage()
                                }
                            }
                        }
                    }

                    override fun onState(state: State) {
                    }

                })
            }

            override fun onFailure(reason: Reason) {
                when(reason){
                    is NfcUserError -> {
                        nfcFailProcess()
                        startFailUIProcess()
                    }
                    is NfcWrongDataError -> {
                        nfcFailProcess()
                        startFailUIProcess()
                        showCheckIdentityInformationDialog()
                    }
                    is NfcTriggerError -> {
                        startFailUIProcess()
                        getNfcFailToastMessage().let {
                            Toasty.error(requireContext(),
                                it, Toasty.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        })
    }

    private fun startFailUIProcess(){
        binding.cardNextView.visibility = View.GONE
        binding.nfcAnimationView.setAnimation(setNfcFailFinishedAnimation())
        binding.nfcAnimationView.repeatCount = setNfcReadingFinishedAnimationRepeatCount()
        binding.tvNfcStatusView.text = getNfcTryAgainText()
        binding.nfcAnimationView.playAnimation()
    }

    private fun getNfcComparisonErrorToastMessage(): String = getString(R.string.nfc_comparison_error)

    private fun getNfcVerificationFailToastMessage(): String = getString(R.string.nfc_verification_error)

    override fun changeStatusColor(): Int = R.color.colorGreen


    private fun getNfcFailToastMessage(): String = getString(R.string.nfc_toast_message)

    private fun getNfcReadingText(): String = getString(R.string.nfc_reading)

    private fun getNfcSuccessText(): String = getString(R.string.nfc_success)

    private fun getNfcTryAgainText(): String = getString(R.string.nfc_try_again)

    override fun showNfcMaxTryErrorDialog() {
        requireContext().alert(false, getString(R.string.go_on),null,getString(R.string.nfc_error_count_title),getString(
            R.string.nfc_error_count_desc),{ dialog ->
            finishNfcModuleWithError()
            dialog.dismiss()
        },{},{})
    }

    private fun setReadingNfcAnimation(): Int = R.raw.nfc_reading

    private fun setReadingNfcAnimationRepeatCount(): Int = LottieDrawable.INFINITE

    private fun setNfcSuccessFinishedAnimation(): Int = R.raw.nfc_success


    private fun setNfcFailFinishedAnimation(): Int = R.raw.nfc_fail

    private fun setNfcReadingFinishedAnimationRepeatCount(): Int = 0

    private fun errorNfcReadText(): String = getString(R.string.nfc_toast_message)

    override fun getLayoutRes(): Int = R.layout.fragment_nfc



    companion object {

        @JvmStatic
        fun newInstance() =
            NfcFragment()
    }
}