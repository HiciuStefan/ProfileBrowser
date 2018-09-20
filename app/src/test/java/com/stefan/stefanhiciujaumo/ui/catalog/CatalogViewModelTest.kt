package com.stefan.stefanhiciujaumo.ui.catalog

import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.repository.CatalogRepository
import com.stefan.stefanhiciujaumo.testHelper.RxSchedulersTestRule
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CatalogViewModelTest {
    @get:Rule
    var rxSchedulersTestRule = RxSchedulersTestRule()

    val catalogRepository: CatalogRepository
    val catalogViewModel: CatalogViewModel

    init {
        catalogRepository = mock(CatalogRepository::class.java)
        catalogViewModel = CatalogViewModel(catalogRepository)
    }

    @Test
    fun testAddSubscriptions_succesful() {
        val mockCatalog = mock(Catalog::class.java)
        given(catalogRepository.getCatalog()).willReturn(Single.just(mockCatalog))
        catalogViewModel.addSubscriptions()
        rxSchedulersTestRule.ioScheduler().triggerActions()
        assertEquals(false, catalogViewModel.loading.get())
        assertEquals(false, catalogViewModel.errorState.get())
        assertEquals(mockCatalog, catalogViewModel.catalog.get())

    }

    @Test
    fun testAddSubscriptions_catalogFail() {
        given(catalogRepository.getCatalog()).willReturn(Single.error(Throwable()))
        catalogViewModel.addSubscriptions()
        rxSchedulersTestRule.ioScheduler().triggerActions()
        assertEquals(catalogViewModel.loading.get(), false)
        assertEquals(catalogViewModel.errorState.get(), true)
        assertEquals(null,catalogViewModel.catalog.get())
    }

}
