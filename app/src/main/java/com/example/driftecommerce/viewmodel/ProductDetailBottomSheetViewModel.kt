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
import com.example.driftecommerce.data.repository.CartRepository
import com.example.driftecommerce.domain.ProductDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import toEntity
import javax.inject.Inject

@HiltViewModel
class ProductDetailBottomSheetViewModel @Inject constructor(
    private val cartRepository: CartRepository
): ViewModel() {
     fun saveProductToCart(product: ProductDomain) {
         viewModelScope.launch {
                cartRepository.saveCartProduct(product)
         }

    }
}