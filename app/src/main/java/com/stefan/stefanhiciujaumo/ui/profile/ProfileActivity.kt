package com.stefan.stefanhiciujaumo.ui.profile

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.view.MotionEvent
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.Person
import com.stefan.stefanhiciujaumo.databinding.ProfileActivityBinding
import com.stefan.stefanhiciujaumo.ui.GestureListener
import com.stefan.stefanhiciujaumo.ui.Swipe
import dagger.android.support.DaggerAppCompatActivity


class ProfileActivity : DaggerAppCompatActivity(), Swipe {


    companion object {
        val PROFILE_ACTIVITY_PERSON = "person"
        fun getIntent(context: Context, person: Person): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(PROFILE_ACTIVITY_PERSON, person)
            return intent
        }
    }

    private var gestureDetectorCompat: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.profile_activity)
        binding.person = intent.getParcelableExtra(PROFILE_ACTIVITY_PERSON)

        // Set activity in the listener.
        gestureDetectorCompat = GestureDetectorCompat(this, GestureListener(this))
    }

    @Override
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetectorCompat?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onSwipeDown() {
        finish()
    }

}