package com.stefan.stefanhiciujaumo.catalog

import android.content.Context
import com.stefan.stefanhiciujaumo.ui.profile.ProfileActivity
import javax.inject.Inject


class CatalogNavigator @Inject constructor(val context: Context) {

    fun goToDetails(person: Person) {
        context.startActivity(ProfileActivity.getIntent(context, person))
    }
}