package com.example.mercadolivre.presentation.search.action

sealed interface SearchAction {
    data object OnButtonClick : SearchAction
}