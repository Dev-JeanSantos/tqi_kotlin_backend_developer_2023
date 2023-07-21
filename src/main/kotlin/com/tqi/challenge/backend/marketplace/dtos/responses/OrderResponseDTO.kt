package com.tqi.challenge.backend.marketplace.dtos.responses

import com.tqi.challenge.backend.marketplace.entities.Product

data class OrderResponseDTO(
    val totalSalePrice: Double,
    val payment: String
)
