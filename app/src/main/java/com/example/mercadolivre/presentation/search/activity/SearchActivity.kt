package com.example.mercadolivre.presentation.search.activity


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.mercadolivre.presentation.search.compose.SearchScreen
import com.example.mercadolivre.presentation.search.event.SearchEvent
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : ComponentActivity() {
    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen(
                onAction = searchViewModel::handleAction
            )
        }
        setViewModelObservers()
    }


    private fun setViewModelObservers() {
        searchViewModel.uiState
            .onEach { uiState ->
                uiState.uiState.let { handleEvents(it) }
            }.launchIn(lifecycleScope)
    }

    private fun handleEvents(event: SearchEvent?) {
        when (event) {
            SearchEvent.NavigateToBookShelf -> callResultAct()
            else -> {}
        }
    }

    private fun callResultAct() {
        Intent(this@SearchActivity, ResultActivity::class.java).apply {
            startActivity(this)
        }
    }
}
