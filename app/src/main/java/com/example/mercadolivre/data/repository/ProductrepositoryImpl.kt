package com.example.mercadolivre.data.repository

import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.data.model.toDomain
import com.example.mercadolivre.data.remote.MercadoLivreApi
import com.example.mercadolivre.data.remote.model.toDomain
import com.example.mercadolivre.domain.model.Product

class ProductRepositoryImpl(
    private val api: MercadoLivreApi
) : ProductRepository {

    override suspend fun searchProducts(query: String): List<ProductSearch> {
        val response = api.searchProducts(query)

        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toDomain() } ?: emptyList()
        } else {
            throw Exception("Erro na busca: ${response.code()} ${response.message()}")
        }
    }

    override suspend fun getProductById(productId: String): Product {
        val response = api.getProductDetails(productId)

        if (response.isSuccessful) {
            return response.body()?.toDomain() ?: throw Exception("Produto não encontrado")
        } else {
            throw Exception("Erro ao buscar detalhes: ${response.code()} ${response.message()}")
        }
    }
}
