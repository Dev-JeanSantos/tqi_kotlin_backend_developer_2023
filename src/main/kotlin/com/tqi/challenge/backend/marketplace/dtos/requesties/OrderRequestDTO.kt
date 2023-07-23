package com.tqi.challenge.backend.marketplace.dtos.requesties

import com.tqi.challenge.backend.marketplace.enums.Payment

data class OrderRequestDTO(
    val items: List<IdItemRequestDTO>,
    val payment: Payment
)
