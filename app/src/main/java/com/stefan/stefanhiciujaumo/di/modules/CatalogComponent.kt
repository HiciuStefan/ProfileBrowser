package com.stefan.stefanhiciujaumo.di.modules

import com.stefan.stefanhiciujaumo.ui.CatalogActivity
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.ContributesAndroidInjector


@Module
abstract class CatalogComponent {
    @ContributesAndroidInjector
    @ActivityKey(CatalogActivity::class)
    internal abstract fun buildCatalogActivity(): CatalogActivity
}