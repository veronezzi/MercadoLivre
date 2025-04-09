package com.example.mercadolivre.data.repository


import com.example.mercadolivre.domain.model.Product

interface ProductDetailRepository {
    suspend fun getProductById(productId: String): Product?
}
