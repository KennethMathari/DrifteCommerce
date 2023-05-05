package com.example.driftecommerce.utils.mappers

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