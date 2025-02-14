package com.example.jetshop.jetshop.data.remote

import com.example.jetshop.jetshop.domain.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProduct():List<Product>
}