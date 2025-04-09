package com.example.mercadolivre.presentation.search.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mercadolivre.R
import com.example.mercadolivre.data.model.ProductSearch
import com.example.mercadolivre.presentation.components.CenterLoading
import com.example.mercadolivre.presentation.components.ErrorMessage
import com.example.mercadolivre.presentation.search.event.SearchEvent
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.mercadolivre.navigation.Screen
import com.example.mercadolivre.presentation.search.action.SearchAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAndResultsScreen(
    navController: NavController,
    viewModel: SearchViewModel = koinViewModel(),
) {
    var query by rememberSaveable { mutableStateOf("") }
    var isShowingResults by rememberSaveable { mutableStateOf(false) }
    var hasSearched by rememberSaveable { mutableStateOf(false) }
    var lastQuery by remember { mutableStateOf("") }

    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(uiState.isLoading) {
        if (!uiState.isLoading && isShowingResults) {
            hasSearched = true
        }
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is SearchEvent.OnBackPressed -> navController.popBackStack()
                is SearchEvent.NavigateToProductDetails -> {
                    navController.navigate(Screen.ProductDetail.withArgs(event.productId))
                }
            }
        }
    }

    LaunchedEffect(isShowingResults, query) {
        if (
            isShowingResults &&
            query.isNotBlank() &&
            (query != lastQuery || uiState.searchProducts.isNullOrEmpty())
        ) {
            viewModel.onViewAction(SearchAction.SearchProduct(query))
            lastQuery = query
        }
    }

    if (!isShowingResults) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEE600))
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ml_logo),
                contentDescription = "Logo Mercado Livre",
                modifier = Modifier.size(240.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("O que você está buscando?") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (query.isNotBlank()) {
                            isShowingResults = true
                        }
                    }
                )
            )

            Button(
                onClick = {
                    if (query.isNotBlank()) isShowingResults = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3483FA),
                    contentColor = Color.White
                )
            ) {
                Icon(Icons.Default.Search, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Buscar")
            }
        }
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Resultados: $query") },
                    navigationIcon = {
                        IconButton(onClick = {
                            isShowingResults = false
                            hasSearched = false
                        }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFFEE600),
                        titleContentColor = Color.Black
                    )
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when {
                    uiState.isLoading -> CenterLoading()
                    uiState.isError -> ErrorMessage(
                        error = uiState.errorMessage.toString(),
                        onRetry = { viewModel.searchProducts(query) }
                    )

                    hasSearched && uiState.searchProducts.isNullOrEmpty() -> EmptyResults(query)
                    else -> ProductGrid(
                        products = uiState.searchProducts ?: emptyList(),
                        onProductClick = {
                            viewModel.onViewAction(SearchAction.ShowProductDetails(it))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyResults(query: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Nenhum resultado encontrado para:")
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "\"$query\"",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray
        )
    }
}

@Composable
private fun ProductGrid(
    products: List<ProductSearch>,
    onProductClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products) { product ->
            ProductItem(
                product = product,
                onClick = { onProductClick(product.id) }
            )
        }
    }
}

@Composable
private fun ProductItem(
    product: ProductSearch,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "R$ ${product.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3483FA)
                )
            }
        }
    }
}
