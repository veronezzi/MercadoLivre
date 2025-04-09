package com.example.mercadolivre.presentation.search.action

sealed interface SearchAction {
    data class SearchProduct(val query: String) : SearchAction
    data class ShowProductDetails(val id: String) : SearchAction
}