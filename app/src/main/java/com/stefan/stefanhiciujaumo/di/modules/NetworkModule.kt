package com.stefan.stefanhiciujaumo.di.modules

import com.stefan.stefanhiciujaumo.network.NetworkCreator
import com.stefan.stefanhiciujaumo.network.catalog.CatalogApi
import dagger.Module
import dagger.Provides


@Module
class NetworkModule {

    @Provides
    fun getCatalogApi(networkFactory: NetworkCreator): CatalogApi {
        return networkFactory.catalogApi
    }
}