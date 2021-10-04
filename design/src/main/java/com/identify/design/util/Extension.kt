package com.identify.design.util


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.Rect
import android.media.Image
import android.util.Size
import android.view.View
import androidx.annotation.CheckResult
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.identify.design.dialogs.InformationDialogFragment
import com.identify.design.dialogs.ProgressDialogFragment
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt


fun Fragment.showInformationDialog(anim : Int?,img : Int?, title : String,description: String,animRepeatCount : Int = LottieDrawable.INFINITE,isImgFrameVisible : Int = View.GONE){
    //val fragment = InformationDialogFragment.newInstance(anim,img,title,description,animRepeatCount,isImgFrameVisible)
   // fragment.show(this.childFragmentManager, InformationDialogFragment::class.java.toString())
}

fun AppCompatActivity.showInformationDialog(anim : Int?,img : Int?, title : String,description: String,animRepeatCount : Int = LottieDrawable.INFINITE,isImgFrameVisible : Int = View.GONE){
    //val fragment = InformationDialogFragment.newInstance(anim,img,title,description,animRepeatCount,isImgFrameVisible)
    //fragment.show(this.supportFragmentManager, InformationDialogFragment::class.java.toString())
}



fun Fragment.showProgressDialog() {
    if(!isProgressShowing()){
        val fragment = ProgressDialogFragment.newInstance()
        this.childFragmentManager.beginTransaction().add(fragment,ProgressDialogFragment::class.java.toString()).commitAllowingStateLoss();
    }
}

fun Fragment.hideProgressDialog(){
    if(isAdded){
        childFragmentManager.findFragmentByTag(ProgressDialogFragment::class.java.toString())?.let {
            if(it is ProgressDialogFragment){
                it.dismissAllowingStateLoss()
            }
        }
    }
}

fun Fragment.isProgressShowing() = if(isAdded){
    childFragmentManager.findFragmentByTag(ProgressDialogFragment::class.java.toString()) != null
}
else{
    true
}

fun Context.alert(isCancelable : Boolean, posBtnText : String?, negBtnText: String?, title : String?, message : String?, positiveClicked : (dialog : DialogInterface) -> Unit, negativeClicked : (dialog : DialogInterface) -> Unit, neutralClicked : (dialog : DialogInterface) -> Unit){
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setCancelable(isCancelable)
    builder.setPositiveButton(posBtnText) { dialog, _ ->
        positiveClicked(dialog)
    }
    builder.setNegativeButton(negBtnText) { dialog, _ ->
        negativeClicked(dialog)
    }
    builder.show()
}

