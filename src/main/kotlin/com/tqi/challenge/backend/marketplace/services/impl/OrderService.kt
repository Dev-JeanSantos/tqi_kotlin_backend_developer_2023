package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.OrderMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.OrderRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.OrderRepository
import com.tqi.challenge.backend.marketplace.services.IOrderService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRequestMapper: OrderRequestMapper,
    private val orderMapper: OrderMapper,
    private val orderRepository: OrderRepository,
) : IOrderService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createOrder(orderRequestDTO: OrderRequestDTO): OrderResponseDTO? {
        logger.info("Start insertOrder, new Order:${orderRequestDTO} - Service")
        val order = orderRequestMapper.map(orderRequestDTO)
        orderRepository.save(order)
        logger.info("End insertOrder of Success - Service")
        return orderMapper.map(order)
    }

    override fun getAll(pagination: Pageable): Page<OrderResponseDTO> {
        logger.info("Start getAll - Service")
        val orders = orderRepository.findAll(pagination)
        logger.info("End getAll - Service")
        return orders.map { t -> orderMapper.map(t) }
    }

    override fun getOrderById(id: Long): OrderResponseDTO {
        logger.info("Start getOrderById - Service")
        logger.info("validating if the Item exists com idOrder:${id} - Service")
        val possibleOrder = orderRepository.findById(id).orElseThrow { NotFoundException("Order by Id: $id Not Found") }
        logger.info("End getOrderById - Service")
        return orderMapper.map(possibleOrder)
    }

    override fun delete(id: Long) {
        logger.info("Start deleteOrderById - Service")
        val order = orderRepository.findById(id).orElseThrow{NotFoundException("Order by Id: $id Not Found")}
        logger.info("End deleteOrderById - Service")
        orderRepository.delete(order)
    }

    override fun update(id: Long, orderRequestDTO: OrderRequestDTO): OrderResponseDTO? {
        logger.info("Start update - Service")
        logger.info("validating if the order exists com idOrder:${id} - Service")
        val order = orderRepository.findById(id).orElseThrow{NotFoundException("Order by Id $id Not Found")}
        logger.info("Order exists com idOrder:${id} - Service")
        order.totalSalePrice = orderRequestMapper.getPriceTotal(orderRequestDTO.items)
        order.payment = orderRequestDTO.payment

        orderRepository.save(order)
        logger.info("Product Update by Success - Service")
        return orderMapper.map(order)
    }
}