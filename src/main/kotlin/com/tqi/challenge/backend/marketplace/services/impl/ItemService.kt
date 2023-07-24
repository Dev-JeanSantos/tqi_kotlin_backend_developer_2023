package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.ItemMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.ItemRequestMapper
import com.tqi.challenge.backend.marketplace.mappers.responses.ItemResponseMapper
import com.tqi.challenge.backend.marketplace.repositories.ItemRepository
import com.tqi.challenge.backend.marketplace.services.IItemService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRequestMapper: ItemRequestMapper,
    private val itemMapper: ItemMapper,
    private val itemRepository: ItemRepository,
    private val itemResponseMapper: ItemResponseMapper


    ) : IItemService {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun createItem(itemRequestDTO: ItemRequestDTO): ItemResponseDTO? {
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

    override fun getAll(pagination: Pageable): Page<ItemResponseDTO> {
        logger.info("Start getAll - Service")
        val items = itemRepository.findAll(pagination)
        logger.info("End getAll - Service")
        return items.map { t -> itemMapper.map(t) }
    }

    override fun getItemById(id: Long): ItemResponseDTO {
        logger.info("Start getItemById - Service")
        logger.info("validating if the Item exists com idItem:${id} - Service")
        val possibleItem =
            itemRepository.findById(id).orElseThrow { NotFoundException("Item by Id: $id Not Found") }
        logger.info("End getItemById - Service")
        return itemMapper.map(possibleItem)
    }
    override fun delete(id: Long) {
        logger.info("Start deleteItemById - Service")
        val item = itemResponseMapper.map(getItemById(id))
        logger.info("End deleteItemById - Service")
        itemRepository.delete(item)
    }

}