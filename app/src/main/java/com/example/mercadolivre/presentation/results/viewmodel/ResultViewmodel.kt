package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.action.ResultAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.search.event.ResultEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResultViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(ResultUiState())
    val uiState = _uiState.asStateFlow()

    fun searchProducts(query: String) {
        viewModelScope.launch {
            // Lógica para buscar produtos
        }
    }

    fun handleAction(action: ResultAction) {
        when (action) {
            ResultAction.OnBackClick -> {
                viewModelScope.launch {
                    _uiState.update {
                        ResultUiState(uiState = ResultEvent.NavigateToBookShelf)
                    }
                }
            }

        }
    }

    data class ResultUiState(
        val uiState: ResultEvent? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

}