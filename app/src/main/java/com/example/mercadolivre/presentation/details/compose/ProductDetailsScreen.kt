package com.example.mercadolivre.presentation.details.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mercadolivre.presentation.search.action.ProductDetailsAction
import com.example.mercadolivre.presentation.search.viewmodel.ProductDetailsViewmodel


@Composable
fun ProductDetailScreen(
    productDetailViewModel: ProductDetailsViewmodel = viewModel(),
    onAction: (ProductDetailsAction) -> Unit = {}

) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Detalhes do Produto")
    }
}
