package com.identify.design.nfc

import android.app.AlertDialog
import android.content.DialogInterface
import com.identify.design.R
import com.identify.design.util.showInformationDialog
import com.identify.sdk.mrz.BaseOcrFragment
import com.identify.sdk.repository.model.mrz.DocType
import kotlinx.android.synthetic.main.fragment_mrz.*

class OcrFragment : BaseOcrFragment() {


    companion object {

        @JvmStatic
        fun newInstance() =
            OcrFragment()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_mrz

    override fun initViews() {
        directCallWaiting = this.directCallWaitingView
        graphicsOverlay = this.graphicsOverlayView
        cameraSourcePreview = this.cameraSourcePreviewView
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
                    if (selectedPosition == 0) selectedOcrItem(DocType.ID_CARD) else selectedOcrItem(DocType.ID_CARD)
                    dialog.dismiss()
                })
            .show()
    }


}