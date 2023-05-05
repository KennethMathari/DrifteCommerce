package com.example.driftecommerce.utils.mappers

import com.example.driftecommerce.data.local.entities.CartEntity
import com.example.driftecommerce.data.local.entities.ProductEntity
import com.example.driftecommerce.domain.ProductDomain

fun ProductEntity.toDomain():ProductDomain{
    return ProductDomain(
        id = this.id,
        imageUrl = this.imageUrl,
        name = this.name,
        price = this.price
    )
}


fun ProductDomain.toEntity(): CartEntity {
    return CartEntity(
        productId = this.id,
        productImage = this.imageUrl,
        productName = this.name,
        productPrice = this.price
    )
}