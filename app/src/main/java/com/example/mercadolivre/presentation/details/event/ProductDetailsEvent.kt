package com.example.mercadolivre.presentation.search.event

sealed interface ProductDetailsEvent {
    data object NavigateToSomeAct : ProductDetailsEvent
}
