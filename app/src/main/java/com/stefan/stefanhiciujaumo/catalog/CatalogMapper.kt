package com.stefan.stefanhiciujaumo.catalog

import com.stefan.stefanhiciujaumo.network.catalog.PersonNetwork
import javax.inject.Inject

class CatalogMapper @Inject constructor() {

    fun fromCatalogResponse(networkPersons: List<PersonNetwork>): Catalog {
        val personList: MutableList<Person> = ArrayList()
        networkPersons.forEach {
            personList.add(
                    Person((it.name ?: "No name") + " " + (it.surname ?: "abcd"),
                            it.region ?: "No region provided",
                            it.age?.let { it.toString() + " years" } ?: "Unknown age",
                            it.gender ?: "No gender provided", it.photo ?: ""))
        }
        return Catalog(personList)
    }
}