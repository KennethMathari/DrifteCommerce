package com.example.driftecommerce.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.repository.ProductListRepository
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {
    private val productListRepository = ProductListRepository()

    fun getProductsList() = viewModelScope.launch {
        val productsList = productListRepository.getProductsList()

        if (productsList == null){
            Log.e("NoProduct","No products available")
        }else{
            Log.e("Products", productsList.data.toString())
        }
    }
}