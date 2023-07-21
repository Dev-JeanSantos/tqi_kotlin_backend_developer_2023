package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Cart
import com.tqi.challenge.backend.marketplace.entities.Category
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.services.impl.CartService
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class CartResponseMapper(
    private val productService: ProductService
) : Mapper<CartResponseDTO, Cart> {
    override fun map(t: CartResponseDTO): Cart {
        return Cart(
            id = t.id,
            priceBySale = t.priceBySale,
            quantityItens = t.quantityItens,
            product = productService.findByName(t.nameProduct)
        )
    }
}
