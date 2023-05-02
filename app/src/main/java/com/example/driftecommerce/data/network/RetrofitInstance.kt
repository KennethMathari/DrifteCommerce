package com.example.driftecommerce.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

//Base URL
const val base_url: String = "https://api.drift.co.ke/api/test/"

//moshi instance
val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

//retrofit instance
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object RetrofitInstance {
    val services: Services by lazy {
        retrofit.create(Services::class.java)
    }

    val apiClient = ApiClient(services)
}