package com.example.driftecommerce.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driftecommerce.data.repository.CartRepository
import com.example.driftecommerce.domain.ProductDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailBottomSheetViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {
    fun saveProductToCart(product: ProductDomain) {
        viewModelScope.launch {
            cartRepository.saveCartProduct(product)
        }

    }
}