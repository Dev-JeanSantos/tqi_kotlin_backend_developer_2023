package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.ItemService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v1/marketing/carts")
class ItemController(
    private val cartService: ItemService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createCart(
        @Valid @RequestBody itemRequestDTO: ItemRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ItemResponseDTO>{
        logger.info("Start createcart - Controller")
        val cartRequestDTO = cartService.createCart(itemRequestDTO)
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