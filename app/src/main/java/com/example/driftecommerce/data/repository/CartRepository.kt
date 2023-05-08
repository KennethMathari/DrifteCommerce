package com.example.driftecommerce.data.repository

import android.util.Log
import com.example.driftecommerce.data.local.dao.CartDao
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.utils.mappers.toDomain
import com.example.driftecommerce.utils.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartDao: CartDao
)  {

    suspend fun saveCartProduct(product: ProductDomain) {
        cartDao.insertCart(product.toEntity())
    }

    suspend fun getCartProducts(): Flow<List<ProductDomain>> {
        val cartProducts = cartDao.getCartList().map {
            it.map {
                it.toDomain()
            }
        }
        return cartProducts
    }
}