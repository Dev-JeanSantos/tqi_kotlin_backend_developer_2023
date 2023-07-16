package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.services.impl.CategoryService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/marketing/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createCategory(
        @RequestBody categoryRequestDTO: CategoryRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategoryRequestDTO>{
        logger.info("Start createCategory - Controller")
        val categoryRequestDTO = categoryService.createCategory(categoryRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createCategory - Controller")
        return ResponseEntity.created(uri).body(categoryRequestDTO)
    }
}