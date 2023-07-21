package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.OrderRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.OrderResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.OrderService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
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
        println(orderRequestDTO)
        println(orderRequestDTO)
        println(orderRequestDTO)
        val orderRequestDTO = orderService.createOrder(orderRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createOrder - Controller")
        return ResponseEntity.created(uri).body(orderRequestDTO)
    }
}