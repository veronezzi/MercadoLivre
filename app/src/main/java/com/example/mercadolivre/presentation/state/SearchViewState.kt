package com.example.mercadolivre.presentation.state

import com.example.mercadolivre.data.model.ProductSearch

data class SearchViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val searchProducts: List<ProductSearch>? = null

) {
    fun onLoading(): SearchViewState {
        return this.copy(isLoading = true, isError = false)
    }

    fun onError(errorMessageInfo: String?): SearchViewState {
        return this.copy(
            isLoading = false,
            isError = true,
            searchProducts = emptyList(),
            errorMessage = errorMessageInfo
        )
    }

    fun onSuccess(searchProduct: List<ProductSearch>?): SearchViewState {
        return this.copy(isLoading = false, isError = false, searchProducts = searchProduct)
    }
}