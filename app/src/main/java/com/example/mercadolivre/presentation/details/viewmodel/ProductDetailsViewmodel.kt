package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.domain.model.Product
import com.example.mercadolivre.domain.usecase.GetProductByIdUseCase
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailsViewmodel(
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product = _product.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun loadProduct(productId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _product.value = getProductByIdUseCase(productId)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }


//
//
//    fun handleAction(action: ProductDetailsAction) {
//        when (action) {
//            ProductDetailsAction.OnBackClick -> {
//                viewModelScope.launch {
//                    _uiState.update {
//                        ProductDetailsUiState(uiState = ProductDetailsEvent.NavigateToSomeAct)
//                    }
//                }
//            }
//
//        }
//    }

    data class ProductDetailsUiState(
        val uiState: ProductDetailsEvent? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

}