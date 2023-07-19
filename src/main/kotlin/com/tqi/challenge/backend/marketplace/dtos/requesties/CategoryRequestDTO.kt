package com.tqi.challenge.backend.marketplace.dtos.requesties

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CategoryRequestDTO(
    @field:NotEmpty(message = "Required field")
    @field:Size(min = 3, max = 30, message = "Field requires 3 to 30 characters")
    val name: String
)