package com.tqi.challenge.backend.marketplace.repositories

import com.tqi.challenge.backend.marketplace.entities.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByName(name: String, pagination: Pageable): Page<Category>
}
