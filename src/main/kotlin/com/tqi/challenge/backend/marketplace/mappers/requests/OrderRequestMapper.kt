package com.tqi.challenge.backend.marketplace.mappers.requests

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Order
import com.tqi.challenge.backend.marketplace.enums.Payment
import com.tqi.challenge.backend.marketplace.mappers.CartMapper
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.mappers.responses.CartResponseMapper
import com.tqi.challenge.backend.marketplace.mappers.responses.ProductResponseMapper
import com.tqi.challenge.backend.marketplace.services.impl.CartService
import org.springframework.stereotype.Component

@Component
class OrderRequestMapper(
    private val cartService: CartService,
    private val  cartResponseMapper: CartResponseMapper

): Mapper<OrderRequestDTO, Order> {
    override fun map(t: OrderRequestDTO):Order {
        return Order(
            cart = cartResponseMapper.map(cartService.getCartById(t.cartId)),
            payment = Payment.DINHEIRO,
            totalSalePrice = cartResponseMapper.map(cartService.getCartById(t.cartId)).priceBySale
        )
    }
}
