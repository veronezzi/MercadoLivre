package com.example.mercadolivre.domain.usecase

import com.example.mercadolivre.data.repository.ProductDetailRepository
import com.example.mercadolivre.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProductByIdUseCase(
    private val repository: ProductDetailRepository
) {
    operator fun invoke(productId: String): Flow<Product?> = flow {
        emit(repository.getProductById(productId))
    }
}
