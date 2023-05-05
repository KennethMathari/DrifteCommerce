package com.example.driftecommerce.data.repository

import android.util.Log
import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.utils.mappers.toEntity
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartDao: CartDao
)  {

    suspend fun saveCartProduct(product: ProductDomain) {
        cartDao.insertCart(product.toEntity())
        Log.e("CartProduct", "Product added to cart: $product")
    }
}