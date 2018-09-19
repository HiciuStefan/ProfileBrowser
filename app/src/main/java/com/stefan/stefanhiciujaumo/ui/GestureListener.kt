package com.stefan.stefanhiciujaumo.ui

import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by stefan on 9/19/2018.
 */

class GestureListener constructor(val swipe: Swipe) : GestureDetector.SimpleOnGestureListener() {


    private val MIN_SWIPE_DISTANCE_Y = 100

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        val movementYAxis = e1.y - e2.y
        if (Math.abs(movementYAxis) > MIN_SWIPE_DISTANCE_Y) {
            swipe.onSwipeDown()
        }
        return true
    }
}