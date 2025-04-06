package com.example.mercadolivre.presentation.results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.data.repository.ProductRepository
import com.example.mercadolivre.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultsViewModel (
    private val repository: ProductRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<ProductSearch>>(emptyList())
    val searchResults: StateFlow<List<ProductSearch>> = _searchResults.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun searchProducts(query: String) {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val results = repository.searchProducts(query)
                _searchResults.value = results
            } catch (e: Exception) {
                _error.value = e.message ?: "Erro ao buscar produtos"
            } finally {
                _isLoading.value = false
            }
        }
    }
}