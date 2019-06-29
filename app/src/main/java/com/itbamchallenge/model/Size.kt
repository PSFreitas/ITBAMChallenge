package com.itbamchallenge.model

import com.google.gson.annotations.SerializedName

class Size {

    @SerializedName(value = "available")
    var available : Boolean = false

    @SerializedName(value = "size")
    val size : String = ""

    @SerializedName(value = "sku")
    val sky : String = ""

}