package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CartRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.CartService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v1/marketing/carts")
class CartController(
    private val cartService: CartService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createCart(
        @Valid @RequestBody cartRequestDTO: CartRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CartResponseDTO>{
        logger.info("Start createcart - Controller")
        val cartRequestDTO = cartService.createCart(cartRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createCart - Controller")
        return ResponseEntity.created(uri).body(cartRequestDTO)
    }

//    @GetMapping("/{id}")
//    fun getOrderById(@PathVariable id: Long): CartResponseDTO {
//        logger.info("Start geOrderById - Controller")
//        return cartService.getOrderById(id)
//    }
}