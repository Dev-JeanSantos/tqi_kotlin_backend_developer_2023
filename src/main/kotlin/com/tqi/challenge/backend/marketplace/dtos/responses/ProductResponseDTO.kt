package com.tqi.challenge.backend.marketplace.dtos.responses

data class ProductResponseDTO(
    val id: Long?,
    val name: String,
    val unityMeasure: String,
    val price: Double,
    val nameCategory: String
)
