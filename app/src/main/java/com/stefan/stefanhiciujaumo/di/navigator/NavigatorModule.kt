package com.stefan.stefanhiciujaumo.di.navigator

import com.stefan.stefanhiciujaumo.catalog.CatalogNavigator
import com.stefan.stefanhiciujaumo.ui.catalog.CatalogActivity
import dagger.Module
import dagger.Provides

/**
 * Created by stefan on 9/18/2018.
 */


@Module
class NavigatorModule {

    @Provides
    fun getNavigator(context: CatalogActivity): CatalogNavigator {
        return CatalogNavigator(context)
    }
}
