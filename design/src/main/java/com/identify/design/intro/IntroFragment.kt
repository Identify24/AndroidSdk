package com.identify.design.intro


import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.identify.design.R
import com.identify.design.databinding.FragmentIntroBinding
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.intro.BaseIntroFragment

class IntroFragment : BaseIntroFragment() {

    val binding by viewBinding(FragmentIntroBinding::bind)

    override fun initViews() {
        btnStart = binding.cardStartView
        relLayWelcome = binding.relLayWelcomeView
        relLaySlider = binding.relLaySliderView
        btnNext = binding.relLayNextView
        viewpager = binding.viewpagerView
        btnBack = binding.relLayBackView
        tabLayout =  binding.tabLayoutView
        tvNext = binding.tvNextView
        imgRightArrow = binding.imgRightArrowView
        tvSkipBack = binding.tvSkipBackView
        imgLeftArrow = binding.imgLeftArrowView
    }

    override fun changeStatusColor(): Int? = android.R.color.transparent

    override fun getCardPhotoModulePair(): List<Pair<Drawable?, String>> = listOf( Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_ocr_illustration), getString(
            R.string.intro_take_photo_desc)))

    override fun setIntroFinishedTextColor(): Int = R.color.colorDarkYellow

    override fun setIntroNextTextColor(): Int = android.R.color.white

    override fun getSpeechModulePair(): List<Pair<Drawable?, String>> = listOf( Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_microphone_toggle), getString(
            R.string.intro_ocr_desc)))

    override fun getSelfieModulePair(): List<Pair<Drawable?, String>> = listOf( Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_vitality_illustration), getString(
        R.string.intro_vitality_desc)))

    override fun getVideoRecordModulePair(): List<Pair<Drawable?, String>> = listOf(Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_vitality_illustration), getString(
        R.string.record_video_desc)))

    override fun getDijitalSignatureModulePair(): List<Pair<Drawable?, String>> = listOf(Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_vitality_illustration), "imza at"))


    override fun getLivenessModulePair(): List<Pair<Drawable?, String>> = listOf(Pair(
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_vitality_illustration), getString(R.string.intro_vitality_desc)))

    override fun getNfcModulePair(): List<Pair<Drawable?, String>> {
        val list = mutableListOf<Pair<Drawable?, String>>()
        list.add(Pair(ContextCompat.getDrawable(requireContext(), R.drawable.ic_ocr_illustration), getString(
             R.string.intro_ocr_desc)))
        list.add(Pair(ContextCompat.getDrawable(requireContext(), R.drawable.ic_nfc_illustration), getString(
             R.string.intro_nfc_desc)))
        return list
    }

    override fun getAgentCallModulePair(): List<Pair<Drawable?, String>> {
        val list = mutableListOf<Pair<Drawable?, String>>()
        list.add(Pair(ContextCompat.getDrawable(requireContext(), R.drawable.ic_customer_representative_illustration), getString(
            R.string.intro_call_desc)))
        list.add(Pair(ContextCompat.getDrawable(requireContext(), R.drawable.ic_tan_illustration), getString(
            R.string.intro_tan_desc)))
        return list
    }

    override fun getIntroAdapter(items: List<Pair<Drawable?, String>>): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        return IntroAdapter(items)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_intro


    companion object {

        @JvmStatic
        fun newInstance() =
            IntroFragment()
    }


}