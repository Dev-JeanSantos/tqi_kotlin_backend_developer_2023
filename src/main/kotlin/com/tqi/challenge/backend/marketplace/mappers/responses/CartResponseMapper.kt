package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Item
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class CartResponseMapper(
    private val productService: ProductService
) : Mapper<CartResponseDTO, Item> {
    override fun map(t: CartResponseDTO): Item {
        return Item(
            id = t.id,
            priceBySale = t.priceBySale,
            quantityItens = t.quantityItens,
            product = productService.findByName(t.nameProduct)
        )
    }
}
