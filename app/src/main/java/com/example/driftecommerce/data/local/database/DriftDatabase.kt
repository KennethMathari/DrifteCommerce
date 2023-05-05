package com.example.driftecommerce.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.data.local.dao.ProductDao
import com.example.driftecommerce.data.local.entities.CartEntity
import com.example.driftecommerce.data.local.entities.ProductEntity

@Database(
    entities = [
                CartEntity::class,
                ProductEntity::class],
    version = 1
)
abstract class DriftDatabase: RoomDatabase() {
    companion object
    {
        val DATABASE_NAME: String = "drift_db"
    }

    abstract fun cartDao(): CartDao
    abstract fun productDao(): ProductDao
}