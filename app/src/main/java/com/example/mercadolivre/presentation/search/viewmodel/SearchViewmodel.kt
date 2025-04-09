package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.domain.usecase.SearchProductUseCase
import com.example.mercadolivre.presentation.search.action.SearchAction
import com.example.mercadolivre.presentation.search.event.SearchEvent
import com.example.mercadolivre.presentation.state.SearchViewState
import com.example.mercadolivre.utils.BaseStatefulViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class SearchViewModel(
    private val searchProductsUseCase: SearchProductUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseStatefulViewModel<SearchViewState, SearchAction, SearchEvent>(
    initialState = SearchViewState()
) {
    override fun onViewAction(action: SearchAction) {
        when (action) {
            is SearchAction.ShowResults -> showResults()
            is SearchAction.SearchProduct -> searchProducts(action.query)
            is SearchAction.ShowProductDetails -> sendEvent(
                SearchEvent.NavigateToProductDetails(
                    action.id
                )
            )
        }
    }

    private fun showResults() {}

    fun searchProducts(query: String) {
        searchProductsUseCase(query)
            .onStart {
                updateState { it.onLoading() }
            }.onEach { result ->
                updateState { it.onSuccess(result) }
            }.catch { error ->
                updateState { it.onError(error.toString()) }
            }.launchIn(viewModelScope)

    }
}