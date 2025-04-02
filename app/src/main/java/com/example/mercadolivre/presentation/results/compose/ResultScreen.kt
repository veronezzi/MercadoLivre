package com.example.mercadolivre.presentation.results.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mercadolivre.presentation.search.action.ResultAction
import com.example.mercadolivre.presentation.search.viewmodel.ResultViewmodel

@Composable
fun ResultsScreen(
    resultViewmodel: ResultViewmodel = viewModel(),
    onAction: (ResultAction) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Resultados da busca")
        Button(onClick = { onAction(ResultAction.OnButtonClick) }) {
            Text("Ir para detalhes")
        }    }
}
