package com.identify.design.nfc

import android.app.AlertDialog
import android.content.DialogInterface
import com.identify.design.R
import com.identify.design.databinding.FragmentMrzBinding
import com.identify.design.util.showInformationDialog
import com.identify.sdk.base.viewBinding.viewBinding
import com.identify.sdk.mrz.newocr.BaseOcrFragment
import com.identify.sdk.repository.model.mrz.DocType

class OcrFragment : BaseOcrFragment() {

    val binding by viewBinding(FragmentMrzBinding::bind)

    companion object {

        @JvmStatic
        fun newInstance() =
            OcrFragment()
    }


    override fun initViews() {
        btnDirectCallWaiting = binding.directCallWaitingView.cardDirectCallWaiting
        overlay = binding.overlay
        textOverlay = binding.textOverlay
        ocrPreview = binding.ocrPreview
    }

    override fun showOcrForPassportInformation() {
        this.showInformationDialog(null, R.drawable.img_passport, getString(R.string.mrz_info_title), getString(R.string.ocr_info_desc_passport))
    }

    override fun showOcrForIdInformation() {
        this.showInformationDialog(null, R.drawable.img_id_card, getString(R.string.mrz_info_title), getString(R.string.ocr_info_desc_id))
    }



    override fun showChoosePassportOrIDCardDialog(selectedOcrItem: (docType: DocType) -> Unit) {
        val items = arrayOf(getString(R.string.with_id_card),getString(R.string.with_passport))
        AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle(getString(R.string.select_ident_item))
            .setSingleChoiceItems(items, 0, null)
            .setPositiveButton(R.string.confirm,
                DialogInterface.OnClickListener { dialog, _ ->
                    val selectedPosition: Int =
                        (dialog as AlertDialog).listView.checkedItemPosition
                    if (selectedPosition == 0) selectedOcrItem(DocType.ID_CARD) else selectedOcrItem(DocType.PASSPORT)
                    dialog.dismiss()
                })
            .show()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_mrz


}