package com.example.jetshop.jetshop.presentation.ProductScreen

import com.example.jetshop.jetshop.domain.model.Product

data class ProductViewState(
    val isLoading:Boolean = false,
    val products:List<Product> = emptyList(),
    val error : String? = null
)
