package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ICategoryService {
    fun createCategory(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO
    fun getAll(nameTutor: String?, pagination: Pageable): Page<CategoryResponseDTO>
    fun getCategoryById(id: Long): CategoryResponseDTO
    fun update(id: Long, categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO?
    fun delete(id: Long)
    fun findByName(nameCategory: String): Category
}
