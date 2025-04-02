package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailsViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun ProductDetailCall() {
        viewModelScope.launch {
            // some product call
        }
    }

    fun handleAction(action: ProductDetailsAction) {
        when (action) {
            ProductDetailsAction.OnBackClick -> {
                viewModelScope.launch {
                    _uiState.update {
                        ProductDetailsUiState(uiState = ProductDetailsEvent.NavigateToBookShelf)
                    }
                }
            }

        }
    }

    data class ProductDetailsUiState(
        val uiState: ProductDetailsEvent? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

}