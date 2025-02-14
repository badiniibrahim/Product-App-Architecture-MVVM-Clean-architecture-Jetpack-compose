package com.example.jetshop.jetshop.data.repository

import arrow.core.Either
import com.example.jetshop.jetshop.data.mapper.toGeneralError
import com.example.jetshop.jetshop.data.remote.ProductApi
import com.example.jetshop.jetshop.domain.model.NetworkError
import com.example.jetshop.jetshop.domain.model.Product
import com.example.jetshop.jetshop.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) :ProductRepository {

    override suspend fun getProduct(): Either<NetworkError, List<Product>> {
       return Either.catch {
           productApi.getProduct()
       }.mapLeft {it.toGeneralError()  }
    }
}