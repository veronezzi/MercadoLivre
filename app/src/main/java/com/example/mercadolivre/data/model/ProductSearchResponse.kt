package com.example.mercadolivre.data.model


data class ProductSearchResponse(val results: List<ProductDto>)

data class ProductDto(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String
)


data class ProductSearch(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String
)

fun ProductDto.toDomain(): ProductSearch {
    return ProductSearch(
        id = id,
        name = title,
        price = price,
        imageUrl = thumbnail
    )
}

