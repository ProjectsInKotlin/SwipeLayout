package com.example.mylynx.swipelayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color.parseColor
import android.R.fraction
import android.graphics.Color
import android.support.v4.view.ViewCompat.setScaleY
import android.support.v4.view.ViewCompat.setScaleX
import android.support.v4.view.ViewCompat.setTranslationY
import android.opengl.ETC1.getHeight
import android.widget.Button
import ru.rambler.libs.swipe_layout.SwipeLayout
import android.R.attr.start
import android.view.animation.LinearInterpolator
import android.animation.ObjectAnimator
import android.widget.Toast
import android.opengl.ETC1.getWidth
import android.opengl.ETC1.getHeight
import android.view.ViewTreeObserver




class MainActivity : AppCompatActivity() {

    inline fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ctx = this
        var swipeLayout_width: Int? = null

        val swipeLayout = findViewById<SwipeLayout>(R.id.MA_swipelayout)
        swipeLayout.getViewTreeObserver().addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                swipeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this)
                swipeLayout.height //height is ready
                swipeLayout.width //width is ready
                swipeLayout_width = swipeLayout.width
                toast(swipeLayout.width.toString())

                val animator = ObjectAnimator()
                animator.target = swipeLayout
                animator.propertyName = "offset"
                animator.interpolator = LinearInterpolator()//default: AccelerateInterpolator
                animator.setIntValues(-swipeLayout_width!!)

                animator.duration = 150// default 200
                animator.start()
            }
        })



        MA_swipelayout.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {
            override fun onRightStickyEdge(swipeLayout: SwipeLayout?, moveToRight: Boolean) {

            }

            override fun onBeginSwipe(swipeLayout: SwipeLayout?, moveToRight: Boolean) {

            }

            override fun onLeftStickyEdge(swipeLayout: SwipeLayout?, moveToRight: Boolean) {

            }

            override fun onSwipeClampReached(swipeLayout: SwipeLayout?, moveToRight: Boolean) {
                Toast.makeText(ctx, swipeLayout!!.offset.toString(), Toast.LENGTH_LONG).show()
            }

        })



    }

}
