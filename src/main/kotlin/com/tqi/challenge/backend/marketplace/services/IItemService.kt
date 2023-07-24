package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IItemService {
    fun createCart(itemRequestDTO: ItemRequestDTO): ItemResponseDTO?
    fun getCartById(id: Long): ItemResponseDTO
    fun getAll(pagination: Pageable): Page<ItemResponseDTO>
    fun getItemById(id: Long): ItemResponseDTO
}
