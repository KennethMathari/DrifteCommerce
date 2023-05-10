package com.example.driftecommerce.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.repository.CartRepository
import com.example.driftecommerce.domain.ProductDomain
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.round

class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _cartProducts = MutableLiveData<List<ProductDomain>>()
    val cartProducts: MutableLiveData<List<ProductDomain>> get() = _cartProducts

    private var _cartTotal = MutableLiveData<Double>()
    val cartTotal: MutableLiveData<Double> get() = _cartTotal

    fun getCartProducts() {
        viewModelScope.launch {
            cartRepository.getCartProducts().collect{
                _cartProducts.value = it
                val totalPrice =it.sumOf { it.price ?: 0.0 }
                val roundedTotalPrice = round(totalPrice*100)/100
                _cartTotal.value = roundedTotalPrice
            }
        }
    }
}