package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import org.springframework.stereotype.Component

@Component
class CategoryResponsePaginationMapper : Mapper<Category, CategoryResponseDTO> {
    override fun map(t: Category): CategoryResponseDTO {
        return CategoryResponseDTO(
            id = t.id,
            name = t.name
        )
    }
}