package com.itbamchallenge.model

import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName(value = "name")
    val name: String = ""

    @SerializedName(value = "style")
    val style: String = ""

    @SerializedName(value = "code_color")
    val codeColor: String = ""

    @SerializedName(value = "color_slug")
    val colorSlug: String = ""

    @SerializedName(value = "color")
    val color: String = ""

    @SerializedName(value = "on_sale")
    val onSale: Boolean = false

    @SerializedName(value = "regular_price")
    val regularPrice: String = ""

    @SerializedName(value = "actual_price")
    val actualPrice: String = ""

    @SerializedName(value = "discount_percentage")
    val discountPercentage: String = ""

    @SerializedName(value = "installments")
    val installments: String = ""

    @SerializedName(value = "image")
    val image: String = ""

    @SerializedName(value = "sizes")
    val sizes: ArrayList<Size> = ArrayList()

}