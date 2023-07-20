package com.tqi.challenge.backend.marketplace.controllers

import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.services.impl.ProductService
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
        logger.info("End createProduct - Controller")
        return ResponseEntity.created(uri).body(productRequestDTO)
    }

    @GetMapping
    fun getAllProducts(
        @PageableDefault(size = 12, sort = ["id"], direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<ProductResponseDTO> {
        logger.info("Start getAllProduct - Controller")
        return productService.getAll(pagination)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ProductResponseDTO {
        logger.info("Start getProductById - Controller")
        return productService.getProductById(id)
    }
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody @Valid productRequestDTO: ProductRequestDTO)
            : ResponseEntity<ProductResponseDTO> {
        logger.info("Start updateProduct - Controller")
        val productResponseDTO = productService.update(id, productRequestDTO)
        logger.info("End updateProduct - Controller")
        return  ResponseEntity.ok().body(productResponseDTO)
    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCategory(@PathVariable id: Long) {
//        categoryService.delete(id)
//    }
}