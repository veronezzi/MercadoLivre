package com.example.mercadolivre.presentation.search.activity


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.mercadolivre.presentation.results.compose.ResultsScreen
import com.example.mercadolivre.presentation.search.compose.SearchScreen
import com.example.mercadolivre.presentation.search.event.ProductDetailsEvent
import com.example.mercadolivre.presentation.search.event.ResultEvent
import com.example.mercadolivre.presentation.search.viewmodel.ResultViewmodel
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import org.koin.androidx.viewmodel.ext.android.viewModel


class ResultActivity : ComponentActivity() {
    private val resultViewmodel: ResultViewmodel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResultsScreen(
                onAction = resultViewmodel::handleAction
            )
        }
        setViewModelObservers()
    }


    private fun setViewModelObservers() {
        resultViewmodel.uiState
            .onEach { uiState ->
                uiState.uiState.let { handleEvents(it) }
            }.launchIn(lifecycleScope)
    }

    private fun handleEvents(event: ResultEvent?) {
        when (event) {
            ResultEvent.NavigateToBookShelf -> callProductDetail()
            else -> {}
        }
    }

    private fun callProductDetail() {
        Intent(this@ResultActivity, ProductDetailsActivity::class.java).apply {
            startActivity(this)
        }
    }
}
