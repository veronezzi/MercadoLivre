package com.example.mercadolivre.data.remote

import com.example.mercadolivre.data.model.ProductSearchResponse
import com.example.mercadolivre.data.remote.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLivreApi {

    @GET("sites/MLB/search")
    suspend fun searchProducts(
        @Query("q") query: String,
        @Query("offset") offset: Int = 0
    ): Response<ProductSearchResponse>

    @GET("items/{id}")
    suspend fun getProductDetails(
        @Path("id") productId: String
    ): Response<ProductResponse>
}
