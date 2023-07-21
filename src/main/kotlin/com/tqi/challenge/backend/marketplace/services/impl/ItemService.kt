package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.ItemMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.ItemRequestMapper
import com.tqi.challenge.backend.marketplace.repositories.ItemRepository
import com.tqi.challenge.backend.marketplace.services.IItemService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRequestMapper: ItemRequestMapper,
    private val itemMapper: ItemMapper,
    private val itemRepository: ItemRepository,

    ) : IItemService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createCart(itemRequestDTO: ItemRequestDTO): ItemResponseDTO? {
        logger.info("Start insertCart, new Cart:${itemRequestDTO} - Service")
        val cart = itemRequestMapper.map(itemRequestDTO)
        itemRepository.save(cart)
        logger.info("End insertCart of Success - Service")
        return itemMapper.map(cart)
    }

    override fun getCartById(id: Long): ItemResponseDTO {
        logger.info("Start getById - Service")
        logger.info("validating if the Cart exists com idProduct:${id} - Service")
        val possibleCart = itemRepository.findById(id).orElseThrow { NotFoundException("Order by Id $id Not Found") }
        logger.info("End getById - Service")
        return itemMapper.map(possibleCart)
    }
}