package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Cart
import org.springframework.stereotype.Component

@Component
class CartMapper: Mapper<Cart, CartResponseDTO> {
    override fun map(t: Cart): CartResponseDTO {
        return CartResponseDTO(
            nameCategory = t.product!!.category.name,
            nameProduct = t.product!!.name,
            quantityItens = t.quantityItens,
            priceBySale = t.priceBySale,
            id = t.id
        )
    }
}
