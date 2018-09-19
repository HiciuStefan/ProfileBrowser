package com.stefan.stefanhiciujaumo.ui.profile

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.Person
import com.stefan.stefanhiciujaumo.databinding.ProfileActivityBinding
import dagger.android.support.DaggerAppCompatActivity

class ProfileActivity : DaggerAppCompatActivity() {
    companion object {
        val PROFILE_ACTIVITY_PERSON = "person"
        fun getIntent(context: Context, person: Person): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(PROFILE_ACTIVITY_PERSON, person)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.profile_activity)
        binding.person = intent.getParcelableExtra(PROFILE_ACTIVITY_PERSON)
    }

}