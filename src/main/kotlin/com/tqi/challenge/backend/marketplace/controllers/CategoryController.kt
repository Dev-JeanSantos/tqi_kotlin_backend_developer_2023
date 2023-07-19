package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.CategoryService
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
@RequestMapping("/api/v1/marketing/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createCategory(
        @Valid @RequestBody categoryRequestDTO: CategoryRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CategoryRequestDTO>{
        logger.info("Start createCategory - Controller")
        val categoryRequestDTO = categoryService.createCategory(categoryRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createCategory - Controller")
        return ResponseEntity.created(uri).body(categoryRequestDTO)
    }

    @GetMapping
    fun getAllCategories(
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 12, sort = ["id"], direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<CategoryResponseDTO> {
        logger.info("Start createCategory - Controller")
        return categoryService.getAll(name, pagination)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): CategoryResponseDTO {
        return categoryService.getCategoryById(id)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody @Valid categoryRequestDTO: CategoryRequestDTO)
            : ResponseEntity<CategoryRequestDTO> {
        val categoryRequestDTO = categoryService.update(id, categoryRequestDTO)
        return  ResponseEntity.ok().body(categoryRequestDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        categoryService.delete(id)
    }
}