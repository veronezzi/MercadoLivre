package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.action.SearchAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.search.event.SearchEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    fun searchProducts(query: String) {
        viewModelScope.launch {
            // will be implemented in future
        }
    }

    fun handleAction(action: SearchAction) {
        when (action) {
            SearchAction.OnButtonClick -> {
                viewModelScope.launch {
                    _uiState.update {
                        SearchUiState(uiState = SearchEvent.NavigateToBookShelf)
                    }
                }
            }

        }
    }

    data class SearchUiState(
        val uiState: SearchEvent? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

}