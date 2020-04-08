package com.shafigh.androidviewandtouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipImage = findViewById<FlipImageView>(R.id.flipImage1)
        flipImage.onDownImage = R.drawable.bird

        flipImage.setImageResource(R.drawable.cat)

        val imageView = findViewById<ImageView>(R.id.imageView)

        imageView.setOnTouchListener(object : View.OnTouchListener{
            //Anonymous object
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when(event?.action){
                    MotionEvent.ACTION_DOWN -> {
                        Log.d("MotionEvent","Down")
                        imageView.setImageResource(R.drawable.cat)
                    }
                    MotionEvent.ACTION_UP -> {
                        Log.d("MotionEvent","Up")
                        imageView.setImageResource(R.drawable.bird)
                    }
                }
                return true
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("MotionEvent","Down touch!")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("MotionEvent","Touch Up!")
            }
        }
        return super.onTouchEvent(event)
    }
}
