package com.example.driftecommerce.data.network

import com.example.driftecommerce.data.network.models.ProductsList
import com.example.driftecommerce.data.network.models.SimpleResponse
import retrofit2.Response

class ApiClient(private val services: Services) {
    suspend fun getProductsList(): SimpleResponse<ProductsList>{
        return safeApiCall { services.getProductsList() }
    }

    /**
     * This function is used to make a safe API call
     */
    private inline fun <T> safeApiCall(
        apiCall: () -> Response<T>,
    ): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.error(e)
        }

    }
}