package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.CartRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Product

interface ICartService {
    fun createCart(cartRequestDTO: CartRequestDTO): CartResponseDTO?
    fun getCartById(id: Long): CartResponseDTO
}
