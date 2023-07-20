package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IProductService {
    fun createProduct(productRequestDTO: ProductRequestDTO): ProductResponseDTO?
    fun getAll(pagination: Pageable): Page<ProductResponseDTO>

}
