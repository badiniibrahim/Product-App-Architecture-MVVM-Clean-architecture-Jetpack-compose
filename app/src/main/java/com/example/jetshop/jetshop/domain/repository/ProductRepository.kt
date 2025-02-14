package com.example.jetshop.jetshop.domain.repository

import arrow.core.Either
import com.example.jetshop.jetshop.domain.model.NetworkError
import com.example.jetshop.jetshop.domain.model.Product

interface ProductRepository {
    suspend fun getProduct():Either<NetworkError,List<Product>>
}