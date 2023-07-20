package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.CartRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CartResponseDTO

interface ICartService {
    fun createCart(cartRequestDTO: CartRequestDTO): CartResponseDTO?
}
