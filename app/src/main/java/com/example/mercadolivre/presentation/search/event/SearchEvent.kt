package com.example.mercadolivre.presentation.search.event

sealed interface SearchEvent {
    data object OnBackPressed : SearchEvent
    data class NavigateToProductDetails(val productId: String) : SearchEvent
}
