package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper() : Mapper<Product, ProductResponseDTO> {
    override fun map(t: Product): ProductResponseDTO {
       return ProductResponseDTO(
           name = t.name,
           unityMeasure = t.unitMeasure,
           price = t.price,
           nameCategory = t.category.name,
           id = t.id
       )
    }
}
