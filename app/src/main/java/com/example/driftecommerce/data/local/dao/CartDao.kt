package com.example.driftecommerce.data.local.dao

import androidx.annotation.RequiresPermission.Read
import androidx.room.*
import com.example.driftecommerce.data.local.entities.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Upsert
    suspend fun insertCart(cartEntity: CartEntity): Long

    @Delete
    suspend fun deleteCart(cartEntity: CartEntity)

    @Query("SELECT * FROM cart")
    fun getCartList(): Flow<List<CartEntity>>
}