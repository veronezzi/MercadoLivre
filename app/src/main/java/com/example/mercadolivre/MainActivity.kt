package com.example.mercadolivre

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mercadolivre.presentation.search.activity.SearchActivity
import com.example.mercadolivre.presentation.search.compose.SearchScreen
import com.example.mercadolivre.ui.theme.MercadoLivreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicia a SearchActivity automaticamente
        startActivity(Intent(this, SearchActivity::class.java))

        // Finaliza MainActivity para que ela não fique na pilha de atividades
        finish()
    }
}

