package com.example.mercadolivre.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val currency: String,
    val condition: String,
    val thumbnail: String,
    val pictures: List<String>,
    val description: String
) : Parcelable

