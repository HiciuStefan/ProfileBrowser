package com.stefan.stefanhiciujaumo.catalog

import com.stefan.stefanhiciujaumo.network.catalog.PersonNetwork
import javax.inject.Inject

class CatalogMapper @Inject constructor() {

    fun fromCatalogResponse(networkPersons: List<PersonNetwork>): Catalog {
        val personList: MutableList<Person> = ArrayList()
        networkPersons.forEach { personList.add(Person(it.name + it.surname, it.region, it.age, it.gender, it.photo)) }
        return Catalog(personList)
    }
}