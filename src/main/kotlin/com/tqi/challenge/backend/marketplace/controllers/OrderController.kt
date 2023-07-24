package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.OrderService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v1/marketing/orders")
class OrderController(
    private val orderService: OrderService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createOrder(
        @Valid @RequestBody orderRequestDTO: OrderRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<OrderResponseDTO>{
        logger.info("Start createOrder - Controller")
        val orderResponseDTO = orderService.createOrder(orderRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createOrder - Controller")
        return ResponseEntity.created(uri).body(orderResponseDTO)
    }

    @GetMapping
    fun getAllOrders(
        @PageableDefault(size = 12, sort = ["id"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<OrderResponseDTO> {
        logger.info("Start getAllOrders - Controller")
        val orders = orderService.getAll(pagination)
        logger.info("End getAllOrders - Controller")
        return orders
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Long): OrderResponseDTO {
        logger.info("Start getOrderById - Controller")
        val possibleOrder = orderService.getOrderById(id)
        logger.info("End getOrderById - Item ${possibleOrder} Found! -Controller")
        return possibleOrder
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteOrder(@PathVariable id: Long) {
        logger.info("Start deleteOrder - Controller")
        logger.info("End deleteOrder - Controller")
        orderService.delete(id)
    }
}