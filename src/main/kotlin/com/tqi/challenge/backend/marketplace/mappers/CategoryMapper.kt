package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import org.springframework.stereotype.Component

@Component
class CategoryMapper : Mapper<Category, CategoryRequestDTO> {
    override fun map(t: Category): CategoryRequestDTO {
       return CategoryRequestDTO(
           name = t.name
       )
    }
}
