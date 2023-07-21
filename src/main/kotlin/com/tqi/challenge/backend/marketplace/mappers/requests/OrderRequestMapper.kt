package com.tqi.challenge.backend.marketplace.mappers.requests

import com.tqi.challenge.backend.marketplace.dtos.requesties.IdItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Order
import com.tqi.challenge.backend.marketplace.enums.Payment
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.mappers.responses.CartResponseMapper
import com.tqi.challenge.backend.marketplace.services.impl.CartService
import org.springframework.stereotype.Component

@Component
class OrderRequestMapper(
    private val cartService: CartService,
    private val  cartResponseMapper: CartResponseMapper

): Mapper<OrderRequestDTO, Order> {
    override fun map(t: OrderRequestDTO):Order {
        return Order(
            payment = Payment.DINHEIRO,
            totalSalePrice = getPriceTotal(t.carts)
        )
    }
    fun getPriceTotal(list: List<IdItemRequestDTO>): Double {
        var custoTotalCompra: Double = 0.0
        for (id in list) {
            val item = cartResponseMapper.map(cartService.getCartById(id.id))
            custoTotalCompra += item.priceBySale
        }
        return custoTotalCompra
    }
}
