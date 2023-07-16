package com.tqi.challenge.backend.marketplace.services

import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO

interface ICategoryService {
    fun createCategory(categoryRequestDTO: CategoryRequestDTO): CategoryRequestDTO

}
