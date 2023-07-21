package com.tqi.challenge.backend.marketplace.dtos.responses

data class ItemResponseDTO(
    val id: Long?,
    val nameCategory: String,
    val nameProduct: String,
    val quantityItens: Int,
    val priceBySale: Double
)
