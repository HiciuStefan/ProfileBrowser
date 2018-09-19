package com.stefan.stefanhiciujaumo.di.modules

import com.stefan.stefanhiciujaumo.ui.catalog.CatalogActivity
import com.stefan.stefanhiciujaumo.ui.profile.ProfileActivity
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileActivityModule {

    @ContributesAndroidInjector
    @ActivityKey(CatalogActivity::class)
    internal abstract fun buildProfileActivity(): ProfileActivity

}