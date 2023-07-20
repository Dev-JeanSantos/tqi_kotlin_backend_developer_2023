package com.tqi.challenge.backend.marketplace.mappers.responses

import com.tqi.challenge.backend.marketplace.dtos.responses.ProductResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Product
import com.tqi.challenge.backend.marketplace.mappers.Mapper
import com.tqi.challenge.backend.marketplace.services.impl.CategoryService
import org.springframework.stereotype.Component

@Component
class ProductResponseMapper(
    private val categoryService: CategoryService
) : Mapper<ProductResponseDTO, Product> {
    override fun map(t: ProductResponseDTO): Product {
        return  Product(
            id = t.id,
            name = t.name,
            price = t.price,
            unitMeasure = t.unityMeasure,
            category = categoryService.findByName(t.nameCategory)
        )
    }
}
