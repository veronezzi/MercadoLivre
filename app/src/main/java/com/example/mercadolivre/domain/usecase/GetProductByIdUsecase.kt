package com.example.mercadolivre.domain.usecase

import com.example.mercadolivre.data.repository.ProductRepository
import com.example.mercadolivre.domain.model.Product

class GetProductByIdUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: String): Product {
        return repository.getProductById(productId)
    }
}
