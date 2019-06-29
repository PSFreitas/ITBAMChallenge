package com.itbamchallenge.network

import com.itbamchallenge.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductsService {

    @GET(value = "/v2/59b6a65a0f0000e90471257d")
    fun getProducts(): Call<ProductResponse>


    companion object Factory {

        private const val BASE_URL = "http://www.mocky.io"

        fun create():ProductsService{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ProductsService::class.java)}

    }


}