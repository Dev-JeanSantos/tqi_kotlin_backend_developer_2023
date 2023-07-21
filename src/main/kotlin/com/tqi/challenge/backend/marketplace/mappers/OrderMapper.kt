package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Order
import org.springframework.stereotype.Component

@Component
class OrderMapper: Mapper<Order, OrderResponseDTO> {
    override fun map(t: Order): OrderResponseDTO {
        return OrderResponseDTO(
            totalSalePrice = t.totalSalePrice,
            payment = t.payment.toString()
        )
    }
}
