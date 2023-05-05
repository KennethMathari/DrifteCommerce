package com.example.driftecommerce.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.driftecommerce.data.local.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Upsert
    suspend fun insertProduct(productEntity: ProductEntity): Long

    @Query("SELECT * FROM products")
    fun getProductList(): Flow<List<ProductEntity>>
}