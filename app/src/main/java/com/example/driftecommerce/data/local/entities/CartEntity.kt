package com.example.driftecommerce.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = false)
    val productId: Int?,
    val productName: String?,
    val productPrice: Double?,
    val productImage: String?,
)
