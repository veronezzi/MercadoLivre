package com.example.mercadolivre.presentation.search.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mercadolivre.R
import com.example.mercadolivre.navigation.Screen
import com.example.mercadolivre.presentation.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo do MercadoLibre
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "MercadoLibre Logo",
            modifier = Modifier.size(120.dp),
            tint = Color(0xFFFEE600)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo de busca
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("O que você está buscando?") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF3483FA),
                unfocusedBorderColor = Color.LightGray
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (query.isNotBlank()) {
                        navController.navigate(Screen.Results.withArgs(query))
                    }
                }
            )
        )
        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color(0xFF3483FA),
                modifier = Modifier.padding(top = 16.dp)
            )
        }


        if (state.error  != null) {
            Text(
                text = state.error.toString(),
                color = Color.Red,
                modifier = Modifier.padding(top = 16.dp)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Botão de busca
        Button(
            onClick = {
                if (query.isNotBlank()) {
                    navController.navigate(Screen.Results.withArgs(query))
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3483FA),
                contentColor = Color.White
            )
        ) {
            Text("Buscar", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
