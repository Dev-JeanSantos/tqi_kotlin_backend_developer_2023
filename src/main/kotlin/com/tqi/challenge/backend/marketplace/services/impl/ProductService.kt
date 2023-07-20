package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.ProductMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.ProductRequestMapper
import com.tqi.challenge.backend.marketplace.mappers.responses.ProductResponsePaginationMapper
import com.tqi.challenge.backend.marketplace.repositories.ProductRepository
import com.tqi.challenge.backend.marketplace.services.IProductService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRequestMapper: ProductRequestMapper,
    private val productMapper: ProductMapper,
    private val productResponsePaginationMapper: ProductResponsePaginationMapper,
    private val productRepository: ProductRepository,
) : IProductService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createProduct(productRequestDTO: ProductRequestDTO): ProductResponseDTO? {
        logger.info("Start insertProduct, new Product:${productRequestDTO} - Service")
        val product = productRequestMapper.map(productRequestDTO)
        productRepository.save(product)
        logger.info("End insertProduct of Success - Service")
        return productMapper.map(product)
    }

    @Transactional
    override fun getAll(
        pagination: Pageable
    ): Page<ProductResponseDTO>{
        val products = productRepository.findAll(pagination)
        return products.map { t -> productResponsePaginationMapper.map(t)}
    }

    override fun getProductById(id: Long): ProductResponseDTO {
        logger.info("Start getById - Service")
        logger.info("validating if the product exists com idProduct:${id} - Service")
        val possibleProduct = productRepository.findById(id).orElseThrow { NotFoundException("Product by Id $id Not Found") }
        logger.info("End getById - Service")
        return productMapper.map(possibleProduct)
    }


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