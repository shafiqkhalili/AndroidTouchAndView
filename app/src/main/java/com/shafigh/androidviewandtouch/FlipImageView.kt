package com.shafigh.androidviewandtouch

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView

class FlipImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
    var onDownImage : Int? = null, var defaultImage: Drawable? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr){


    init {
        defaultImage = drawable
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        if (resId != onDownImage) {
            defaultImage = resources.getDrawable(resId, null)
        }
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                onDownImage?.let {image ->
                    setImageResource(image) }
            }
            MotionEvent.ACTION_UP -> {
                defaultImage?.let{image ->
                    setImageDrawable(image)}
            }
        }
        return true
    }
}