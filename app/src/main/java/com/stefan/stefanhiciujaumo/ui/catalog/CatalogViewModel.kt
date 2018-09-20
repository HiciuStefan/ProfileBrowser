package com.stefan.stefanhiciujaumo.ui.catalog

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.CatalogNavigator
import com.stefan.stefanhiciujaumo.catalog.repository.CatalogRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class CatalogViewModel @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {

    lateinit var catalogNavigator: CatalogNavigator
    var catalog: ObservableField<Catalog> = ObservableField()

    val bag: CompositeDisposable
    var loading = ObservableBoolean()
    val errorState: ObservableBoolean = ObservableBoolean(false)

    init {
        bag = CompositeDisposable()
        loading.set(true)
    }

    fun getNavigator(): CatalogNavigator {
        return catalogNavigator
    }


    fun addSubscriptions() {
        loading.set(true)
        bag.add(catalogRepository.getCatalog()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { catalog ->
                            this.catalog.set(catalog)
                            loading.set(false)
                        },
                        { throwable ->
                            kotlin.run {
                                loading.set(false)
                                Timber.e(throwable)
                                errorState.set(true)
                            }
                        }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        bag.dispose()
    }

}