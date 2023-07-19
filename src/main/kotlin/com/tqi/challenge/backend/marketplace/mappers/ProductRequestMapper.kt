package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.dtos.requesties.ProductRequestDTO
import com.tqi.challenge.backend.marketplace.entities.Category
import com.tqi.challenge.backend.marketplace.entities.Product
import com.tqi.challenge.backend.marketplace.services.impl.CategoryService
import org.springframework.stereotype.Component

@Component
class ProductRequestMapper(
    private val categoryService: CategoryService,
    private val categoryResponseMapper: CategoryResponseMapper,
) : Mapper<ProductRequestDTO, Product> {
    override fun map(t: ProductRequestDTO): Product {
        return  Product(
            name = t.name,
            price = t.price,
            unitMeasure = t.unityMeasure,
            category = categoryResponseMapper.map(categoryService.getCategoryById(t.idCategory))
        )
    }
}
