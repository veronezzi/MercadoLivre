package com.example.mercadolivre.presentation.search.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.action.SearchAction
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = viewModel(),
    onAction: (SearchAction) -> Unit = {}
) {

    // will be implemented in future
//    val uiState by searchViewModel.getSearchFeedState.collectAsStateWithLifecycle()


    var query by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar produtos") }
        )
        Button(onClick = { onAction(SearchAction.OnButtonClick) }) {
            Text("Buscar")
        }
    }
}
