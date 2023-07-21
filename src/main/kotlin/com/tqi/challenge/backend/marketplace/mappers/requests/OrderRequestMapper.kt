package com.tqi.challenge.backend.marketplace.mappers.requests

import com.tqi.challenge.backend.marketplace.dtos.requesties.IdItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Order
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.mappers.responses.ItemResponseMapper
import com.tqi.challenge.backend.marketplace.services.impl.ItemService
import org.springframework.stereotype.Component

@Component
class OrderRequestMapper(
    private val cartService: ItemService,
    private val  itemResponseMapper: ItemResponseMapper

): Mapper<OrderRequestDTO, Order> {
    override fun map(t: OrderRequestDTO):Order {
        return Order(
            payment = t.payment,
            totalSalePrice = getPriceTotal(t.carts)
        )
    }
    fun getPriceTotal(list: List<IdItemRequestDTO>): Double {
        var custoTotalCompra: Double = 0.0
        for (id in list) {
            val item = itemResponseMapper.map(cartService.getCartById(id.id))
            custoTotalCompra += item.priceBySale
        }
        return custoTotalCompra
    }
}
