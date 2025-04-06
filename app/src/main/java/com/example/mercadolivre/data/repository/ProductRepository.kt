package com.example.mercadolivre.data.repository


import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.domain.model.Product

interface ProductRepository {
    suspend fun searchProducts(query: String): List<ProductSearch>
    suspend fun getProductById(productId: String): Product
}
