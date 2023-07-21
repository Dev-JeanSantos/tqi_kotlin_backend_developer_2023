package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.ItemRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO

interface IItemService {
    fun createCart(itemRequestDTO: ItemRequestDTO): ItemResponseDTO?
    fun getCartById(id: Long): ItemResponseDTO
}
