package com.stefan.stefanhiciujaumo.catalog

import android.os.Parcel
import android.os.Parcelable


class Person(val username: String,
             val region: String,
             val age: String,
             val gender: String,
             val photoUrl: String) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(region)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeString(photoUrl)
    }

    override fun describeContents(): Int {
        return 0
    }


}