package com.example.mercadolivre.presentation.search.action

sealed interface ProductDetailsAction {
    data object OnBackClick : ProductDetailsAction
}