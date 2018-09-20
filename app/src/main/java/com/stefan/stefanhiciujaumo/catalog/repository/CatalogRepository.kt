package com.stefan.stefanhiciujaumo.catalog.repository

import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.CatalogMapper
import com.stefan.stefanhiciujaumo.network.catalog.CatalogApi
import com.stefan.stefanhiciujaumo.network.catalog.PersonNetwork
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by stefan on 9/18/2018.
 */


public class CatalogRepository @Inject constructor(private val catalogApi: CatalogApi,
                                                   private val catalogMapper: CatalogMapper) {
    fun getCatalog(): Single<Catalog> {
        return catalogApi.getCatalog(500)
                .map { networkPersons: List<PersonNetwork> -> catalogMapper.fromCatalogResponse(networkPersons) }
    }

}