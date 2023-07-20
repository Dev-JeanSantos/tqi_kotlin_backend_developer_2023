package com.tqi.challenge.backend.marketplace.mappers.requests

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import org.springframework.stereotype.Component

@Component
class CategoryRequestMapper : Mapper<CategoryRequestDTO, Category> {
    override fun map(t: CategoryRequestDTO): Category {
        return  Category(
            name = t.name
        )
    }
}
