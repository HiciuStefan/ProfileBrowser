package com.stefan.stefanhiciujaumo.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hypnoweb.hypnowebapp.di.ViewModelFactory.ViewModelFactory
import com.stefan.stefanhiciujaumo.catalog.CatalogViewModel
import com.stefan.stefanhiciujaumo.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by stefan on 9/18/2018.
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CatalogViewModel::class)
    internal abstract fun bindAndevClientViewModel(viewModel: CatalogViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
