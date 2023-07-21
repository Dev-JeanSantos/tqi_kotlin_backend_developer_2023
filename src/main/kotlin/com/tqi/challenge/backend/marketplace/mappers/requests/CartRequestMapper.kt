package com.tqi.challenge.backend.marketplace.mappers.requests

import com.tqi.challenge.backend.marketplace.dtos.requesties.CartRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Item
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.mappers.responses.ProductResponseMapper
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class CartRequestMapper(
    private val productService: ProductService,
    private val productResponseMapper: ProductResponseMapper
): Mapper<CartRequestDTO, Item> {
    override fun map(t: CartRequestDTO): Item {
        return Item(
            product = productResponseMapper.map(productService.getProductById(t.productId)),
            quantityItens = t.quantityItens,
            priceBySale = productResponseMapper.map(productService.getProductById(t.productId)).price * t.quantityItens
        )
    }
}
