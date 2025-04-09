package com.example.mercadolivre.data.repository

import com.example.mercadolivre.data.model.MockSearchData
import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.data.remote.MercadoLivreApi
import com.example.mercadolivre.domain.model.Product

class ProductDetailrepositoryImpl(
    private val api: MercadoLivreApi
) : ProductDetailRepository {

    override suspend fun getProductById(productId: String): Product? {
        return MockSearchData.getProductDetails(productId)

//        val response = api.getProductDetails(productId)
//
//        if (response.isSuccessful) {
//            return response.body()?.toDomain() ?: throw Exception("Produto não encontrado")
//        } else {
//            throw Exception("Erro ao buscar detalhes: ${response.code()} ${response.message()}")
//        }
    }
}
