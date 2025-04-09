package com.example.mercadolivre.presentation.search.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.mercadolivre.domain.usecase.GetProductByIdUseCase
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.state.ProductDetailsViewState
import com.example.mercadolivre.utils.BaseStatefulViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class ProductDetailsViewmodel(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseStatefulViewModel<ProductDetailsViewState, ProductDetailsAction, ProductDetailsEvent>(
    initialState = ProductDetailsViewState()
) {
    override fun onViewAction(action: ProductDetailsAction) {
        when (action) {
            is ProductDetailsAction.PurchaseProduct -> purshaseProduct()
            is ProductDetailsAction.OnBackPressed -> sendEvent(ProductDetailsEvent.OnBackPressed)
            is ProductDetailsAction.LoadProduct -> loadProduct(action.productId)
        }
    }

    fun loadProduct(productId: String) {
        getProductByIdUseCase(productId).onStart {
            updateState { it.onLoading() }
        }.onEach { product ->
            updateState { it.onSuccess(productDetails = product) }
        }.catch { error ->
            updateState { it.onError(error.toString()) }
        }.launchIn(viewModelScope)
    }


    private fun purshaseProduct() {}

}