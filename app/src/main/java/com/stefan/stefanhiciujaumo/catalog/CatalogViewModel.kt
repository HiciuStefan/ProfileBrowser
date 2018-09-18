package com.stefan.stefanhiciujaumo.catalog

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.stefan.stefanhiciujaumo.catalog.repository.CatalogRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class CatalogViewModel @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {

    val bag: CompositeDisposable
    var loading = ObservableBoolean()

    init {
        bag = CompositeDisposable()
        loading.set(true)
    }

    fun addSubscriptions() {
        bag.add(catalogRepository.getCatalog()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { catalog ->
                            loading.set(false)

                        },
                        { throwable -> Timber.e(throwable) }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        bag.dispose()
    }

}