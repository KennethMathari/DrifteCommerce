package com.example.driftecommerce.data.network

import com.example.driftecommerce.data.network.models.ProductsList
import retrofit2.Response
import retrofit2.http.GET

interface Services {

    @GET("products")
    suspend fun getProductsList(): Response<ProductsList>
}