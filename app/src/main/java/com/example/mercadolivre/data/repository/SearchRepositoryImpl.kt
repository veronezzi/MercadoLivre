package com.example.mercadolivre.data.repository

import com.example.mercadolivre.data.model.MockSearchData
import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.data.remote.MercadoLivreApi
import com.example.mercadolivre.domain.model.Product

class SearchRepositoryImpl(
    private val api: MercadoLivreApi
) : SearchRepository {

    override suspend fun searchProducts(query: String): List<ProductSearch> {

        return MockSearchData.mockProducts
//        val response = api.searchProducts(query)
//
//        if (response.isSuccessful) {
//            return response.body()?.results?.map { it.toDomain() } ?: emptyList()
//        } else {
//            throw Exception("Erro na busca: ${response.code()} ${response.message()}")
//        }
    }
}
