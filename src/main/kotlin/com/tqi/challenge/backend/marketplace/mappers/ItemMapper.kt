package com.tqi.challenge.backend.marketplace.mappers

import com.tqi.challenge.backend.marketplace.dtos.responses.ItemResponseDTO
import com.tqi.challenge.backend.marketplace.entities.Item
import org.springframework.stereotype.Component

@Component
class ItemMapper: Mapper<Item, ItemResponseDTO> {
    override fun map(t: Item): ItemResponseDTO {
        return ItemResponseDTO(
            nameCategory = t.product!!.category.name,
            nameProduct = t.product!!.name,
            quantityItens = t.quantityItens,
            priceBySale = t.priceBySale,
            id = t.id
        )
    }
}
