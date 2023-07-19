package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.mappers.ProductMapper
import com.tqi.challenge.backend.marketplace.mappers.ProductRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.ProductRepository
import com.tqi.challenge.backend.marketplace.services.IProductService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRequestMapper: ProductRequestMapper,
    private val productMapper: ProductMapper,
    private val productRepository: ProductRepository
) : IProductService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createProduct(productRequestDTO: ProductRequestDTO): ProductResponseDTO? {
        logger.info("Start insertProduct, new Product:${productRequestDTO} - Service")
        val product = productRequestMapper.map(productRequestDTO)
        productRepository.save(product)
        logger.info("End insertAdoption of Success - Service")
        return productMapper.map(product)
    }

//    @Transactional
//    override fun createPro(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO {
//
//        logger.info("Start insertCategory, new Category:${categoryRequestDTO} - Service")
//        val category = categoryRequestMapper.map(categoryRequestDTO)
//        categoryRepository.save(category)
//        logger.info("End insertAdoption of Success - Service")
//        return categoryMapper.map(category)
//
//    }
//
//    @Transactional(readOnly = true)
//    override fun getAll(
//        name: String?,
//        pagination: Pageable
//    ): Page<CategoryResponseDTO> {
//
//        val categories = name?.let {
//            categoryRepository.findByName(name, pagination)
//        } ?: categoryRepository.findAll(pagination)
//
//        return categories.map { t -> categoryResponsePaginationMapper.map(t) }
//    }
//
//    @Transactional(readOnly = true)
//    override fun getCategoryById(id: Long): CategoryResponseDTO {
//
//        logger.info("Start getById - Service")
//        logger.info("validating if the adoption exists com idAdoption:${id} - Service")
//        logger.info("End getById - Service")
//        val possibleCategory =
//            categoryRepository.findById(id).orElseThrow { NotFoundException("Category by Id $id Not Found") }
//        return categoryResponsePaginationMapper.map(possibleCategory)
//
//    }
//
//    @Transactional
//    override fun update(id: Long, categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO? {
//
//        val category = categoryRepository.findById(id).orElseThrow { NotFoundException("Category by Id $id Not Found") }
//
//        category.name = categoryRequestDTO.name
//        categoryRepository.save(category)
//        return categoryMapper.map(category)
//    }
//    override fun delete(id: Long) {
//        val category = this.getCategoryById(id)
//        categoryRepository.delete(categoryResponseMapper.map(category))
//    }
}