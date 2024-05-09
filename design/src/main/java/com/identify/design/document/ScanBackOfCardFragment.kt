package com.identify.design.document

import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.identify.design.R
import com.identify.design.databinding.FragmentScanBackOfCardBinding
import com.identify.sdk.SdkApp
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.document.BaseScanBackOfCardFragment
import com.identify.sdk.scanner.TakePhotoListener
import com.identify.sdk.scanner.data.Corners
import com.identify.sdk.scanner.data.CornersDetectorListener
import com.identify.sdk.scanner.enums.EFlashStatus

class ScanBackOfCardFragment : BaseScanBackOfCardFragment() {

    val binding by viewBinding(FragmentScanBackOfCardBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.shutter.setOnClickListener(takeCardPhotoOnClickListener)
        binding.flashToggle.setOnClickListener(toggleFlashClickListener)
        setCornersDetectorListener(cornersDetectorListener)
        setViewForOpenCvCameraInitialize(binding.viewFinder)
        setBusyStatusListener(busyStatusListener)

        binding.closeScanner.setOnClickListener {
            closeScanner()
        }

        getHoldSteadyMessage().let {
            if (binding.tvHoldSteady.text.isNullOrEmpty()) {
                binding.tvHoldSteady.text = it
            }
        }
    }

    private val takeCardPhotoOnClickListener = View.OnClickListener {
        binding.rlHoldSteady.visibility = View.VISIBLE

        takePhoto(true, object : TakePhotoListener {
            override fun onSuccess(photo: Uri) {
                goToBackCropPage(photo)
                onStop()
            }

            override fun onFailure(throwable: Throwable) {
                Log.e(ScanFrontOfCardFragment::class.java.simpleName, throwable.message, throwable) //
            }

        })
    }

    private val toggleFlashClickListener = View.OnClickListener {
        toggleFlash { flashStatus ->
            when (flashStatus) {
                EFlashStatus.ON -> getFlashOnSrc()
                EFlashStatus.OFF -> getFlashOffSrc()
                else -> getFlashOffSrc()
            }.let {
                binding.flashToggle.setImageResource(it)
            }
        }
    }

    private val cornersDetectorListener = object : CornersDetectorListener {
        override fun onCornersDetected(corners: Corners) {
            if (distanceValueControl(corners, 100, 100)) {
                binding.cornerDetector.onCornersDetected(corners)
                SdkApp.identityOptions?.let { identifyOptions ->
                    if (identifyOptions.getAutoCapture()) {
                        checkTakeAutoPhoto {
                            if (it) {
                                takeAutoPhoto()
                            }
                        }
                    } else {
                        showWarningMessage()
                    }

                }
            } else
                binding.cornerDetector.onCornersNotDetected()
        }

        override fun onCornersNotDetected() {
            binding.cornerDetector.onCornersNotDetected()
        }

    }

    private val busyStatusListener: (Boolean) -> Unit = { busyStatus ->
        if (busyStatus) {
            binding.progress.visibility = View.VISIBLE
            binding.rlHoldSteady.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
        }
    }

    private fun takeAutoPhoto() {
        binding.tvAutoCaptureCounter.visibility = View.VISIBLE
        var second = 3
        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvAutoCaptureCounter.text = second.toString()
                second--
            }

            override fun onFinish() {
                binding.tvAutoCaptureCounter.visibility = View.GONE
            }
        }
        timer.start()
    }

    override fun onStop() {
        super.onStop()

        timer.cancel()
    }


    private val timer = object : CountDownTimer(2000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            binding.rlHoldSteady.visibility = View.GONE
        }
    }
    private fun showWarningMessage() {
        binding.rlHoldSteady.visibility = View.VISIBLE
        timer.start()
    }
    private fun getFlashOnSrc(): Int = R.drawable.ic_flash_on

    private fun getFlashOffSrc(): Int = R.drawable.ic_flash_off

    private fun getHoldSteadyMessage() = getString(R.string.hold_steady)

    override fun changeStatusColor(): Int? = R.color.colorGreen

    override fun getLayoutRes(): Int = R.layout.fragment_scan_back_of_card

    companion object {

        @JvmStatic
        fun newInstance() =
                ScanBackOfCardFragment()
    }
}