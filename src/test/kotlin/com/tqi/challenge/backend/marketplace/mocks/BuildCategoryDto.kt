package com.tqi.challenge.backend.marketplace.mocks

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO

object BuildCategoryDto {
    fun buildCategoryDto(
        id: Long = 1,
        name: String = "Bebidas"
    ) = CategoryRequestDTO(
        name = name
    )
}