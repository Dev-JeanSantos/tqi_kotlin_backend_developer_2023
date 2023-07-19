package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface ICategoryService {
    fun createCategory(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO
    fun getAll(nameTutor: String?, pagination: Pageable): Page<CategoryResponseDTO>

}
