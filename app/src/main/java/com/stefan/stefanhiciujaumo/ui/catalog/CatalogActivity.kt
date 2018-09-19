package com.stefan.stefanhiciujaumo.ui.catalog

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.CatalogNavigator
import com.stefan.stefanhiciujaumo.databinding.CatalogActivityBinding
import com.stefan.stefanhiciujaumo.di.modules.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CatalogActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var catalogNavigator: CatalogNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: CatalogActivityBinding = DataBindingUtil.setContentView(this, R.layout.catalog_activity)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CatalogViewModel::class.java)
        viewModel.catalogNavigator = catalogNavigator
        binding.viewModel = viewModel
        viewModel.addSubscriptions()
    }


}
