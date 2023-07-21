package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO

interface IOrderService {
    fun createOrder(orderRequestDTO: OrderRequestDTO): OrderResponseDTO?
}
