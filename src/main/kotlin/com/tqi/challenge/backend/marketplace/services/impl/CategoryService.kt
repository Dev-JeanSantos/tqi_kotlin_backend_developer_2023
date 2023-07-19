package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.CategoryMapper
import com.tqi.challenge.backend.marketplace.mappers.CategoryRequestMapper
import com.tqi.challenge.backend.marketplace.mappers.CategoryResponseMapper
import com.tqi.challenge.backend.marketplace.mappers.CategoryResponsePaginationMapper
import com.tqi.challenge.backend.marketplace.repositories.CategoryRepository
import com.tqi.challenge.backend.marketplace.services.ICategoryService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRequestMapper: CategoryRequestMapper,
    private val categoryResponseMapper: CategoryResponseMapper,
    private val categoryResponsePaginationMapper: CategoryResponsePaginationMapper,
    private val categoryMapper: CategoryMapper,
    private val categoryRepository: CategoryRepository,
) : ICategoryService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun createCategory(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO {

        logger.info("Start insertCategory, new Category:${categoryRequestDTO} - Service")
        val category = categoryRequestMapper.map(categoryRequestDTO)
        categoryRepository.save(category)
        logger.info("End insertAdoption of Success - Service")
        return categoryMapper.map(category)

    }

    override fun getAll(
        name: String?,
        pagination: Pageable
    ): Page<CategoryResponseDTO> {

        val categories = name?.let {
            categoryRepository.findByName(name, pagination)
        } ?: categoryRepository.findAll(pagination)

        return categories.map { t -> categoryResponsePaginationMapper.map(t) }
    }

    override fun getCategoryById(id: Long): CategoryResponseDTO {

        logger.info("Start getById - Service")
        logger.info("validating if the adoption exists com idAdoption:${id} - Service")
        logger.info("End getById - Service")
        val possibleCategory =
            categoryRepository.findById(id).orElseThrow { NotFoundException("Category by Id $id Not Found") }
        return categoryResponsePaginationMapper.map(possibleCategory)

    }

    override fun update(id: Long, categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO? {

        val category = categoryRepository.findById(id).orElseThrow { NotFoundException("Category by Id $id Not Found") }

        category.name = categoryRequestDTO.name
        categoryRepository.save(category)
        return categoryMapper.map(category)
    }
    override fun delete(id: Long) {
        val category = this.getCategoryById(id)
        categoryRepository.delete(categoryResponseMapper.map(category))
    }
}
