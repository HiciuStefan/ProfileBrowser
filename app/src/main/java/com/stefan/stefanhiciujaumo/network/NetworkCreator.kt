package com.stefan.stefanhiciujaumo.network

import com.stefan.stefanhiciujaumo.BuildConfig
import com.stefan.stefanhiciujaumo.network.catalog.CatalogApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class NetworkCreator @Inject constructor() {

    private val retrofitBuilder: Retrofit

    val catalogApi: CatalogApi
        get() = retrofitBuilder.create(CatalogApi::class.java)

    init {
        retrofitBuilder = Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
