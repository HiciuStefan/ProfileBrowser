package com.stefan.stefanhiciujaumo.catalog.repository

import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.CatalogMapper
import com.stefan.stefanhiciujaumo.network.catalog.CatalogApi
import com.stefan.stefanhiciujaumo.network.catalog.PersonNetwork
import io.reactivex.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock

/**
 * Created by stefan on 9/19/2018.
 */
class CatalogRepositoryTest {

    @Mock
    lateinit var catalogApi: CatalogApi

    @Mock
    lateinit var catalogMpapper: CatalogMapper

    val catalogRepository: CatalogRepository

    init {
        catalogRepository = CatalogRepository(catalogApi, catalogMpapper)
    }

    @Test
    fun getCatalog() {
        val personNetworkList: ArrayList<PersonNetwork> = arrayListOf()
        val mockPerson1 = mock(PersonNetwork::class.java)
        val catalog: Catalog = mock(Catalog::class.java)

        personNetworkList.add(mockPerson1)
        given(catalogApi.getCatalog(500)).willReturn(Single.just(personNetworkList))
        given(catalogMpapper.fromCatalogResponse(personNetworkList)).willReturn(catalog)

        catalogRepository.getCatalog().test().assertComplete().assertValue(catalog)
    }

}