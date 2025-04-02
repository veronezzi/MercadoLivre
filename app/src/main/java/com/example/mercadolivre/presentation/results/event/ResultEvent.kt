package com.example.mercadolivre.presentation.search.event

sealed interface ResultEvent {
    data object NavigateToBookShelf : ResultEvent
}
