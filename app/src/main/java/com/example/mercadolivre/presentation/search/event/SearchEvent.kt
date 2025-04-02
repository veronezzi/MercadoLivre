package com.example.mercadolivre.presentation.search.event

sealed interface SearchEvent {
    data object NavigateToBookShelf : SearchEvent
}
