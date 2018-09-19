package com.stefan.stefanhiciujaumo.di.modules

import com.stefan.stefanhiciujaumo.di.navigator.NavigatorModule
import com.stefan.stefanhiciujaumo.ui.catalog.CatalogActivity
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.ContributesAndroidInjector


@Module
abstract class CatalogActivityModule {

    @ContributesAndroidInjector(modules = [NavigatorModule::class])
    @ActivityKey(CatalogActivity::class)
    internal abstract fun buildCatalogActivity(): CatalogActivity

}