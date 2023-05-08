package com.example.driftecommerce.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.repository.CartRepository
import com.example.driftecommerce.domain.ProductDomain
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _cartProducts = MutableLiveData<List<ProductDomain>>()
    val cartProducts: MutableLiveData<List<ProductDomain>> get() = _cartProducts
    fun getCartProducts() {
        viewModelScope.launch {
            cartRepository.getCartProducts().collect{
                _cartProducts.value = it
                Log.e("Cart Products:", it.toString())
            }
        }
    }
}