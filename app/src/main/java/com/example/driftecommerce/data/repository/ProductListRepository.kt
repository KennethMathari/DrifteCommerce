package com.example.driftecommerce.data.repository

import com.example.driftecommerce.data.network.RetrofitInstance
import com.example.driftecommerce.data.network.models.ProductsList

class ProductListRepository {

    suspend fun getProductsList(): ProductsList? {
        val request = RetrofitInstance.apiClient.getProductsList()

        if (request.failed || !request.isSuccessful) {
            return null
        }

        return request.body
    }
}