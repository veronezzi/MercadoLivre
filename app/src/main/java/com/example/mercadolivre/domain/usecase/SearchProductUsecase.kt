package com.example.mercadolivre.domain.usecase

import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.data.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchProductUseCase(
    private val repository: SearchRepository
) {
    operator fun invoke(query: String): Flow<List<ProductSearch>> = flow {
        emit(repository.searchProducts(query))
    }
}
