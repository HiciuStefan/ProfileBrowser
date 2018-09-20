package com.stefan.stefanhiciujaumo.catalog

import com.stefan.stefanhiciujaumo.network.catalog.PersonNetwork
import junit.framework.Assert.assertEquals
import org.junit.Test

class CatalogMapperTest {

    val name = "testValue"
    val surname = "testValue"
    val region = "testValue"
    val age = 0
    val gender = "testValue"
    val url = "testValue"

    val mappedNoNameNoSurname = "No name provided"
    val mappedOnlyName = name + " "
    val mappedOnlySurname = surname
    val mappedNameSurname = name + " " + surname
    val mappedRegion = region
    val mappedNoRegion = "No region provided"
    val mappedAge = age.toString() + " years"
    val mappedNoAge = "Unknown age"
    val mappedGender = gender
    val mappedNoGender = "No gender provided"
    val mappedPhoto = url
    val mappedNoPhoto = ""


    @Test
    fun fromCatalogResponse() {
        val mockedPersonNoData: PersonNetwork = getPerson()
        val mockedPersonOnlyName: PersonNetwork = getPerson(name = name)
        val mockedPersonOnlySurname: PersonNetwork = getPerson(surname = surname)
        val mockedPersonNameSurname: PersonNetwork = getPerson(name, surname)
        val mockedPersonOnlyRegion: PersonNetwork = getPerson(region = region)
        val mockedPersonOnlyAge: PersonNetwork = getPerson(age = age)
        val mockedPersonOnlyGender: PersonNetwork = getPerson(gender = gender)
        val mockedPersonOnlyUrl: PersonNetwork = getPerson(url = url)
        val mockedPersonFullData: PersonNetwork = getPerson(name, surname, region, age, gender, url)
        val networkResponse: List<PersonNetwork> = arrayListOf(mockedPersonNoData, mockedPersonOnlyName, mockedPersonOnlySurname, mockedPersonNameSurname,
                mockedPersonOnlyRegion, mockedPersonOnlyAge, mockedPersonOnlyGender, mockedPersonOnlyUrl, mockedPersonFullData)

        val catalogMapper = CatalogMapper()
        val catalog = catalogMapper.fromCatalogResponse(networkResponse)
        val mappedPersons = catalog.persons

        assertEquals(networkResponse.size, mappedPersons.size)

        val mappedPersonNoData = catalog.persons.get(networkResponse.indexOf(mockedPersonNoData))
        assertEquals(mappedNoAge, mappedPersonNoData.age)
        assertEquals(mappedNoNameNoSurname, mappedPersonNoData.username)
        assertEquals(mappedNoRegion, mappedPersonNoData.region)
        assertEquals(mappedNoGender, mappedPersonNoData.gender)
        assertEquals(mappedNoPhoto, mappedPersonNoData.photoUrl)

        val mappedPersonOnlyName = catalog.persons.get(networkResponse.indexOf(mockedPersonOnlyName))
        assertEquals(mappedOnlyName, mappedPersonOnlyName.username)

        val mappedPersonOnlySurname = catalog.persons.get(networkResponse.indexOf(mockedPersonOnlySurname))
        assertEquals(mappedOnlySurname, mappedPersonOnlySurname.username)

        val mappedPersonNameSurname = catalog.persons.get(networkResponse.indexOf(mockedPersonNameSurname))
        assertEquals(mappedNameSurname, mappedPersonNameSurname.username)

        val mappedPersonOnlyRegion = catalog.persons.get(networkResponse.indexOf(mockedPersonOnlyRegion))
        assertEquals(mappedRegion, mappedPersonOnlyRegion.region)

        val mappedPersonOnlyGender = catalog.persons.get(networkResponse.indexOf(mockedPersonOnlyGender))
        assertEquals(mappedGender, mappedPersonOnlyGender.gender)

        val mappedPersonOnlyUrl = catalog.persons.get(networkResponse.indexOf(mockedPersonOnlyUrl))
        assertEquals(mappedPhoto, mappedPersonOnlyUrl.photoUrl)

        val mappedPersonFullData = catalog.persons.get(networkResponse.indexOf(mockedPersonFullData))
        assertEquals(mappedAge, mappedPersonFullData.age)
        assertEquals(mappedNameSurname, mappedPersonFullData.username)
        assertEquals(mappedRegion, mappedPersonFullData.region)
        assertEquals(mappedGender, mappedPersonFullData.gender)
        assertEquals(mappedPhoto, mappedPersonFullData.photoUrl)

    }

    private fun getPerson(name: String? = null, surname: String? = null, region: String? = null, age: Int? = null, gender: String? = null, url: String? = null): PersonNetwork {
        return PersonNetwork(name, surname, gender, age, region, url)
    }


}