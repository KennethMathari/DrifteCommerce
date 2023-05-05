package com.example.driftecommerce.data.repository

import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.data.local.dao.ProductDao
import com.example.driftecommerce.data.network.RetrofitInstance
import com.example.driftecommerce.data.network.Services
import com.example.driftecommerce.data.network.models.ProductsList
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.utils.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import toEntity
import toProductEntity

class ProductListRepository constructor(
    private val productDao: ProductDao,
    private val services: Services
) {

    suspend fun getProductsList(): Flow<List<ProductDomain>>?
    {
        return try {
            val response = services.getProductsList()
            if (response.isSuccessful) {
                for (products in response.body()?.data!!) {
                    if (products != null) {
                        productDao.insertProduct(products.toProductEntity())
                    }
                }
                val cachedProducts = productDao.getProductList().map { it ->
                    it.map {
                        it.toDomain()
                    }
                }
                cachedProducts
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}