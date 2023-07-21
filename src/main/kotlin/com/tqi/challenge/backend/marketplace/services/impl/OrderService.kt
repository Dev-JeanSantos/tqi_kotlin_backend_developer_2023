package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.mappers.OrderMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.OrderRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.OrderRepository
import com.tqi.challenge.backend.marketplace.services.IOrderService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRequestMapper: OrderRequestMapper,
    private val orderMapper: OrderMapper,
    private val orderRepository: OrderRepository
) : IOrderService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createOrder(orderRequestDTO: OrderRequestDTO): OrderResponseDTO? {
        logger.info("Start insertOrder, new Order:${orderRequestDTO} - Service")
        val order = orderRequestMapper.map(orderRequestDTO)
        orderRepository.save(order)
        logger.info("End insertOrder of Success - Service")
        return orderMapper.map(order)
    }
}