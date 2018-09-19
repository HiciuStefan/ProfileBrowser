package com.stefan.stefanhiciujaumo.catalog

import android.os.Parcel
import android.os.Parcelable


class Person(username: String?,
             region: String?,
             age: Int?,
             gender: String?,
             var photoUrl: String?) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }

    val username: String? = username
        get() = field ?: "No username provided"

    val region: String? = region
        get() = field ?: "No region provided"

    var age: String? = age?.let { age.toString() + " years" } ?: "Unknown age"


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
        age = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(photoUrl)
        parcel.writeString(age)
    }

    override fun describeContents(): Int {
        return 0
    }


}