package com.stefan.stefanhiciujaumo.network.catalog

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface CatalogApi {

    @GET("/api?ext")
    fun getCatalog(@Query("amount") amount: Int): Single<List<PersonNetwork>>
}