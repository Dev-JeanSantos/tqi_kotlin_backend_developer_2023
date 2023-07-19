package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/api/v1/marketing/products")
class ProductController(
    private val productService: ProductService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createProduct(
        @Valid @RequestBody productRequestDTO: ProductRequestDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductResponseDTO>{
        logger.info("Start createProduct - Controller")
        val productRequestDTO = productService.createProduct(productRequestDTO)
        val uri = uriBuilder.path("id").build().toUri()
        logger.info("End createCategory - Controller")
        println(productRequestDTO)
        return ResponseEntity.created(uri).body(productRequestDTO)
    }

//    @GetMapping
//    fun getAllCategories(
//        @RequestParam(required = false) name: String?,
//        @PageableDefault(size = 12, sort = ["id"], direction = Sort.Direction.ASC) pagination: Pageable
//    ): Page<CategoryResponseDTO> {
//        logger.info("Start createCategory - Controller")
//        return categoryService.getAll(name, pagination)
//    }
//
//    @GetMapping("/{id}")
//    fun getCategoryById(@PathVariable id: Long): CategoryResponseDTO {
//        return categoryService.getCategoryById(id)
//    }
//
//    @PutMapping("/{id}")
//    fun updateCategory(@PathVariable id: Long, @RequestBody @Valid categoryRequestDTO: CategoryRequestDTO)
//            : ResponseEntity<CategoryRequestDTO> {
//        val categoryRequestDTO = categoryService.update(id, categoryRequestDTO)
//        return  ResponseEntity.ok().body(categoryRequestDTO)
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCategory(@PathVariable id: Long) {
//        categoryService.delete(id)
//    }
}