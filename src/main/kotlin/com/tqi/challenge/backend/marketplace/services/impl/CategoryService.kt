package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.mappers.CategoryMapper
import com.tqi.challenge.backend.marketplace.mappers.CategoryRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.CategoryRepository
import com.tqi.challenge.backend.marketplace.services.ICategoryService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRequestMapper: CategoryRequestMapper,
    private val categoryMapper: CategoryMapper,
    private val categoryRepository: CategoryRepository,
): ICategoryService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun createCategory(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO {

        logger.info("Start insertCategory, new Category:${categoryRequestDTO} - Service")
        val category = categoryRequestMapper.map(categoryRequestDTO)
        categoryRepository.save(category)
        logger.info("End insertAdoption of Success - Service")
        return categoryMapper.map(category)

    }

}
