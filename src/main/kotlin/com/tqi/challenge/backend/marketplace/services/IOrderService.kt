package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IOrderService {
    fun createOrder(orderRequestDTO: OrderRequestDTO): OrderResponseDTO?
    fun getAll(pagination: Pageable): Page<OrderResponseDTO>
    fun getOrderById(id: Long): OrderResponseDTO
}
