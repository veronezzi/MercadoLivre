package com.example.mercadolivre

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.mercadolivre.data.remote.RetrofitClient
import com.example.mercadolivre.navigation.MercadoLibreNavGraph
import com.example.mercadolivre.ui.theme.MercadoLivreTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadoLivreTheme {
                MercadoLibreNavGraph()
            }
        }
    }
}
