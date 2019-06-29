package com.itbamchallenge.network

import com.google.gson.annotations.SerializedName
import com.itbamchallenge.model.Product

data class ProductResponse(

    @SerializedName(value = "products")
    val products : List<Product>
)