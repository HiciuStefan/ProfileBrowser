package com.stefan.stefanhiciujaumo.ui.viewadapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.stefan.stefanhiciujaumo.R
import com.stefan.stefanhiciujaumo.catalog.Catalog
import com.stefan.stefanhiciujaumo.catalog.Person
import com.stefan.stefanhiciujaumo.databinding.CatalogPersonBinding

/**
 * Created by stefan on 9/19/2018.
 */

class GridViewAdapter(private val context: Context,
                      private val catalog: Catalog) : BaseAdapter() {

    override fun getCount(): Int = catalog.persons.size

    override fun getItem(position: Int): Person = catalog.persons.get(position)

    override fun getItemId(position: Int): Long = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            val binding = DataBindingUtil.inflate<CatalogPersonBinding>(LayoutInflater.from(context), R.layout.catalog_person, parent, false)
            binding.person = getItem(position)
            view = binding.root
        } else {
            val binding = DataBindingUtil.findBinding<CatalogPersonBinding>(convertView)
            binding!!.person = getItem(position)
            view = binding!!.root
        }

        return view
    }

}