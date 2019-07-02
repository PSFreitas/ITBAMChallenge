package com.itbamchallenge.network

import com.google.gson.annotations.SerializedName
import com.itbamchallenge.model.Product

/**
 *  Classe responsável por pegar o resposta da requisição feita para a API
 *
 *  @property products Lista de produtos
 */
data class ProductResponse(

    @SerializedName(value = "products")
    val products : List<Product>
)