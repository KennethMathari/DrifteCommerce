package com.example.driftecommerce.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.data.repository.ProductListRepository
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {
    //Product list details
    private val _productsList = MutableLiveData<List<Product?>?>()
    val productsList: LiveData<List<Product?>?> get() = _productsList

    private val productListRepository = ProductListRepository()

    fun getProductsList() = viewModelScope.launch {
        //Fetch the product list from  the Repository layer
        val productsList = productListRepository.getProductsList()

        if (productsList == null){
            //Set the product result to null
            _productsList.value = null
            return@launch
            Log.e("NoProduct","No products available")
        }else{
            _productsList.value = productsList.data
            Log.e("Products", productsList.data.toString())
        }
    }
}