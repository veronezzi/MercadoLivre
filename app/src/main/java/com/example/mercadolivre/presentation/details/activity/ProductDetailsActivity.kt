package com.example.mercadolivre.presentation.search.activity


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.mercadolivre.presentation.details.compose.ProductDetailScreen
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductDetailsActivity : ComponentActivity() {
    private val productDetailViewModel: ProductDetailsViewmodel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ProductDetailScreen(
//                onAction = productDetailViewModel::handleAction
//            )
        }
        setViewModelObservers()
    }

    private fun setViewModelObservers() {
//        productDetailViewModel.uiState
//            .onEach { uiState ->
//                uiState.uiState.let { handleEvents(it) }
//            }.launchIn(lifecycleScope)
    }

    private fun handleEvents(event: ProductDetailsEvent?) {
        when (event) {
            ProductDetailsEvent.NavigateToSomeAct -> callSomeAct(this)
            else -> {}
        }
    }
    private fun callSomeAct(context: Context) {
        Toast.makeText(context, "Calling some act", Toast.LENGTH_LONG).show()
    }

}
