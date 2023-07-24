package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.ItemService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v1/marketing/items")
class ItemController(
    private val itemService: ItemService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createItem(
        @Valid @RequestBody itemRequestDTO: ItemRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ItemResponseDTO> {
        logger.info("Start createItem - Controller")
        val itemRequestDTO = itemService.createCart(itemRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createItem - Controller")
        return ResponseEntity.created(uri).body(itemRequestDTO)
    }

    @GetMapping
    fun getAllItem(
        @PageableDefault(size = 12, sort = ["id"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<ItemResponseDTO> {
        logger.info("Start getAllItem - Controller")
        val items = itemService.getAll(pagination)
        logger.info("End getAllItem - Controller")
        return items
    }

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): ItemResponseDTO {
        logger.info("Start geItemById - Controller")
        val possibleItem = itemService.getItemById(id)
        logger.info("End geItemById - Item ${possibleItem} Found! -Controller")
        return possibleItem
    }
}