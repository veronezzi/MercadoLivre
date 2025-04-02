package com.example.mercadolivre.presentation.search.action

sealed interface ProductDetailsAction {
    data object ButtonClick : ProductDetailsAction
}