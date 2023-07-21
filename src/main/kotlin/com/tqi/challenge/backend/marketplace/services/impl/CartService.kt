package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.CartRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Product
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.CartMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.CartRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.CartRepository
import com.tqi.challenge.backend.marketplace.services.ICartService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRequestMapper: CartRequestMapper,
    private val cartMapper: CartMapper,
    private val cartRepository: CartRepository,

    ) : ICartService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createCart(cartRequestDTO: CartRequestDTO): CartResponseDTO? {
        logger.info("Start insertCart, new Cart:${cartRequestDTO} - Service")
        val cart = cartRequestMapper.map(cartRequestDTO)
        cartRepository.save(cart)
        logger.info("End insertCart of Success - Service")
        return cartMapper.map(cart)
    }

    override fun getCartById(id: Long): CartResponseDTO {
        logger.info("Start getById - Service")
        logger.info("validating if the Cart exists com idProduct:${id} - Service")
        val possibleCart = cartRepository.findById(id).orElseThrow { NotFoundException("Order by Id $id Not Found") }
        logger.info("End getById - Service")
        return cartMapper.map(possibleCart)
    }
}