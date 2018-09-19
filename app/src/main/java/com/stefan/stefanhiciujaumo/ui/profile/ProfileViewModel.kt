package com.stefan.stefanhiciujaumo.ui.profile

import android.arch.lifecycle.ViewModel
import com.stefan.stefanhiciujaumo.catalog.repository.CatalogRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {

    val bag: CompositeDisposable

    init {
        bag = CompositeDisposable()
    }

    override fun onCleared() {
        super.onCleared()
        bag.dispose()
    }

}