package com.example.mercadolivre.presentation.search.action

sealed interface ResultAction {
    data object OnButtonClick : ResultAction
}