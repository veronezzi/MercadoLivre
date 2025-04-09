package com.example.mercadolivre.data.repository


import com.example.mercadolivre.data.model.ProductSearch

interface SearchRepository {
    suspend fun searchProducts(query: String): List<ProductSearch>
}
