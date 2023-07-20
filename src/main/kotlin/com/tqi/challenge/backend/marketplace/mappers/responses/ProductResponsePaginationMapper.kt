package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Product
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import org.springframework.stereotype.Component

@Component
class ProductResponsePaginationMapper : Mapper<Product, ProductResponseDTO> {
    override fun map(t: Product): ProductResponseDTO {
        return ProductResponseDTO(
            id = t.id,
            name = t.name,
            unityMeasure = t.unitMeasure,
            price = t.price,
            nameCategory = t.category.name
        )
    }
}