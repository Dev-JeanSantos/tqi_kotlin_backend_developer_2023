package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.responses.CategoryResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import org.springframework.stereotype.Component

@Component
class CategoryResponseMapper : Mapper<CategoryResponseDTO, Category> {
    override fun map(t: CategoryResponseDTO): Category {
        return  Category(
            id = t.id,
            name = t.name
        )
    }
}
