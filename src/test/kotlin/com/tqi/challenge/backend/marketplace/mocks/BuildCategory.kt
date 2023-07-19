package com.tqi.challenge.backend.marketplace.mocks

import com.tqi.challenge.backend.marketplace.entities.Category


object BuildCategory {
    fun buildCategory(
        id: Long = 1L,
        name: String = "PAPELARIA"
    ) = Category(
        id = id,
        name = name
    )
}
