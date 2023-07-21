package com.tqi.challenge.backend.marketplace.dtos.requesties

import com.tqi.challenge.backend.marketplace.enums.Payment

data class OrderRequestDTO(
    val cartId: Long,
    val carts: List<IdItemRequestDTO>,
    val payment: Payment
)
