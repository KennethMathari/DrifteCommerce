package com.example.driftecommerce.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val imageUrl: String?,
    val name: String?,
    val price: Double?
)