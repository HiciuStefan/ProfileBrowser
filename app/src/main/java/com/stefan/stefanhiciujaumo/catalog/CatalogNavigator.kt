package com.stefan.stefanhiciujaumo.catalog

import android.content.Context
import android.content.Intent
import com.stefan.stefanhiciujaumo.ui.profile.ProfileActivity
import javax.inject.Inject

/**
 * Created by stefan on 9/18/2018.
 */

class CatalogNavigator @Inject constructor(val context: Context) {

    fun goToDetails(get: Person) {
        val intent: Intent = Intent(context, ProfileActivity::class.java)

        context.startActivity(intent)
    }
}