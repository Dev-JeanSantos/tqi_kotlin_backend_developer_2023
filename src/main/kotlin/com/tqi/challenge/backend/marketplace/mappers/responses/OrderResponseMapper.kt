package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Order
import com.tqi.challenge.backend.marketplace.enums.Payment
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class OrderResponseMapper(

    private val productService: ProductService
) : Mapper<OrderResponseDTO, Order> {
    override fun map(t: OrderResponseDTO): Order {
        return Order(
            payment = Payment.valueOf(t.payment),
            totalSalePrice = t.totalSalePrice
        )
    }
}
