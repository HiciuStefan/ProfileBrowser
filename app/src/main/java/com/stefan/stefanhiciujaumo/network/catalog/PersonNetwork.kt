package com.stefan.stefanhiciujaumo.network.catalog

import com.google.gson.annotations.SerializedName

/**
 * Created by stefan on 9/18/2018.
 */
class PersonNetwork(val name: String,
                    val surname: String,
                    val gender: String,
                    @SerializedName("age") val age: Int,
                    val region: String,
                    @SerializedName("photo") val photo: String)