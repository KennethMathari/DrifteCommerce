package com.example.driftecommerce.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.data.local.database.DriftDatabase
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.domain.ProductDomain
import kotlinx.coroutines.launch
import toEntity
import javax.inject.Inject

class ProductDetailBottomSheetViewModel (
): ViewModel() {
     fun saveProductToCart(product: ProductDomain) {
         viewModelScope.launch {

//             val db = Room.databaseBuilder(
//                 application,
//                 DriftDatabase::class.java,
//                 "drift_database"
//             ).build()
//
//             val cartDao = db.cartDao
//             cartDao.insertCart(product.toEntity())
            // driftDatabase.cartDao.insertCart(product.toEntity())
         }

    }
}