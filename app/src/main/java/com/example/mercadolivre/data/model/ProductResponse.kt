package com.example.mercadolivre.data.remote.model

import com.example.mercadolivre.domain.model.Product

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val currency_id: String,
    val condition: String,
    val description: String,
    val thumbnail: String,
    val pictures: List<PictureResponse>,
)

data class PictureResponse(val url: String)

fun ProductResponse.toDomain() = Product(
    id = id,
    title = title,
    price = price,
    currency = currency_id,
    condition = condition,
    pictures = pictures.map { it.url },
    description = description,
    thumbnail = thumbnail
)
