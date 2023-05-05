package com.example.driftecommerce.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.data.repository.ProductListRepository
import com.example.driftecommerce.domain.ProductDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productListRepository: ProductListRepository
) : ViewModel() {
    //Product list details
    private val _productsList = MutableLiveData<List<ProductDomain>>()
    val productsList: LiveData<List<ProductDomain>?> get() = _productsList

    fun getProductsList() = viewModelScope.launch {
        //Fetch the product list from  the Repository layer
//        val productsList = productListRepository.getProductsList()
//
//        if (productsList == null){
//            //Set the product result to null
//            _productsList.value = null
//            return@launch
//            Log.e("NoProduct","No products available")
//        }else{
//            _productsList.value = productsList.data
//            Log.e("Products", productsList.data.toString())
//        }
        productListRepository.getProductsList()?.collect{
            _productsList.value = it
            Log.e("Products", it.toString())
        }
    }
}