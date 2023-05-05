import com.example.driftecommerce.data.local.entities.CartEntity
import com.example.driftecommerce.data.local.entities.ProductEntity
import com.example.driftecommerce.data.network.models.Product

fun Product.toEntity(): CartEntity {
    return CartEntity(
        productId = this.id,
        productName = this.name,
        productPrice = this.price,
        productImage = this.imageUrl
    )
}

fun Product.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        imageUrl = this.imageUrl,
        name = this.name,
        price = this.price
    )
}