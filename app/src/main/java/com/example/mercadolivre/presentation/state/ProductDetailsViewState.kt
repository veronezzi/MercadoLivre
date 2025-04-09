package com.example.mercadolivre.presentation.state

import com.example.mercadolivre.domain.model.Product

data class ProductDetailsViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val productDetails: Product? = null
) {
    fun onLoading(): ProductDetailsViewState {
        return this.copy(isLoading = true, isError = false)
    }

    fun onError(errorMessageInfo: String?): ProductDetailsViewState {
        return this.copy(isLoading = false, isError = true, productDetails = null, errorMessage = errorMessageInfo)
    }

    fun onSuccess(productDetails: Product?): ProductDetailsViewState {
        return this.copy(isLoading = false, isError = false, productDetails = productDetails)
    }
}