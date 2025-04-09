package com.example.mercadolivre.presentation.search.action

sealed interface ProductDetailsAction {
    object OnBackPressed : ProductDetailsAction
    object PurchaseProduct : ProductDetailsAction
    data class LoadProduct(val productId: String) : ProductDetailsAction
}