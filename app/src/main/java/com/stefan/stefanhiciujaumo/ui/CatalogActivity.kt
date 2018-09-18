package com.stefan.stefanhiciujaumo.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.hypnoweb.hypnowebapp.di.ViewModelFactory.ViewModelFactory
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.CatalogViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CatalogActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CatalogViewModel::class.java)
        viewModel.addSubscriptions()
    }

}
