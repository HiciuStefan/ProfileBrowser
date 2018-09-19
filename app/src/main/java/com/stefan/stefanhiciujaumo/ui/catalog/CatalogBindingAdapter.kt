package com.stefan.stefanhiciujaumo.ui.catalog

import android.databinding.BindingAdapter
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Picasso
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.CatalogNavigator
import com.stefan.stefanhiciujaumo.ui.viewadapters.GridViewAdapter


@BindingAdapter("loading")
fun setLoadingContentLoadingProgressBar(progressBar: ProgressBar?, loading: Boolean?) {
    val progressBar2: ProgressBar? = null
    loading?.let {
        when (it) {
            true -> progressBar2?.visibility = VISIBLE
            else -> progressBar?.visibility = INVISIBLE
        }
    }
}


@BindingAdapter("catalog", "navigator")
fun setLoadingContentLoadingProgressBar(gridView: GridView?, catalog: Catalog?, navigator: CatalogNavigator) {

    gridView?.let {
        catalog?.let {
            gridView.adapter = GridViewAdapter(gridView.context, catalog)
            gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
                navigator.goToDetails(catalog.persons.get(position))
            }
        }
    }
}

@BindingAdapter("src")
fun setImage(imageView: ImageView?, url: String?) {
    imageView?.let { Picasso.get().load(url).error(R.drawable.no_image).fit().into(imageView) }
}