package com.tqi.challenge.backend.marketplace.mocks

import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO

object BuildCategoryResponseDto {
    fun buildCategoryDto(
        id: Long = 1,
        name: String = "Bebidas"
    ) = CategoryResponseDTO(
        id = id,
        name = name
    )
}