package com.example.mercadolivre.data.model

import com.example.mercadolivre.domain.model.Product

object MockSearchData {

    val mockProducts = listOf(
        ProductSearch(
            id = "MLB1",
            name = "Samsung Galaxy S23 Ultra",
            price = 5999.99,
            imageUrl = "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp"
        ),
        ProductSearch(
            id = "MLB2",
            name = "Motorola Edge 40 Neo",
            price = 2299.90,
            imageUrl = "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp"
        ),
        ProductSearch(
            id = "MLB3",
            name = "Xiaomi Redmi Note 13 Pro",
            price = 1899.00,
            imageUrl = "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp"
        ),
        ProductSearch(
            id = "MLB4",
            name = "Realme C67 256GB",
            price = 1299.00,
            imageUrl = "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp"
        ),
        ProductSearch(
            id = "MLB5",
            name = "Asus ROG Phone 7",
            price = 4999.00,
            imageUrl = "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp"
        )
    )

    fun getProductDetails(id: String): Product? {
        return when (id) {
            "MLB1" -> Product(
                id = "MLB1",
                title = "Samsung Galaxy S23 Ultra 512GB",
                price = 5999.99,
                thumbnail = "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp",
                condition = "new",
                currency = "BRL",
                description = "O Galaxy S23 Ultra é o topo de linha da Samsung com câmera de 200 MP, tela AMOLED 120Hz e S Pen.",
                pictures = listOf(
                    "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_604807-MLA79305392360_092024-F.webp",
                )
            )
            "MLB2" -> Product(
                id = "MLB2",
                title = "Motorola Edge 40 Neo 256GB",
                price = 2299.90,
                thumbnail = "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp",
                condition = "new",
                currency = "BRL",
                description = "Com tela curva pOLED de 6.55\", o Edge 40 Neo entrega fluidez com 144Hz e design elegante.",
                pictures = listOf(
                    "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_648373-MLA74525556610_022024-F.webp",
                )
            )
            "MLB3" -> Product(
                id = "MLB3",
                title = "Xiaomi Redmi Note 13 Pro 256GB",
                price = 1899.00,
                thumbnail = "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp",
                condition = "new",
                currency = "BRL",
                description = "Smartphone potente com câmera de 200MP, bateria de longa duração e tela AMOLED de 120Hz.",
                pictures = listOf(
                    "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_712967-MLA53467905885_012023-F.webp",
                )
            )
            "MLB4" -> Product(
                id = "MLB4",
                title = "Realme C67 256GB",
                price = 1299.00,
                thumbnail =  "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp",
                condition = "new",
                currency = "BRL",
                description = "Celular com ótimo custo-benefício, 256GB de armazenamento e câmera dupla de 108MP.",
                pictures = listOf(
                    "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_970963-MLU77165843626_072024-F.webp",
                )
            )
            "MLB5" -> Product(
                id = "MLB5",
                title = "Asus ROG Phone 7 512GB",
                price = 4999.00,
                thumbnail = "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp",
                condition = "new",
                currency = "BRL",
                description = "Celular gamer da Asus com Snapdragon 8 Gen 2, tela AMOLED de 165Hz e sistema de refrigeração avançado.",
                pictures = listOf(
                    "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_2X_893513-MLU78903951210_092024-F.webp",
                )
            )
            else -> null
        }
    }
}
