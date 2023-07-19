package com.tqi.challenge.backend.marketplace.dtos.requesties

import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class ProductRequestDTO(
    @field:NotEmpty(message = "Required field")
    @field:Size(min = 3, max = 30, message = "Field requires 3 to 30 characters")
    val name: String,
    @field:NotEmpty(message = "Required field")
    @field:Size(min = 3, max = 30, message = "Field requires 3 to 30 characters")
    val unityMeasure: String,
    @Digits(integer = 2, fraction = 1)
    val price: Double,
    @Min(1)
    val idCategory: Long
)
