package com.tqi.challenge.backend.marketplace.repositories

import com.tqi.challenge.backend.marketplace.entities.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByName(name: String?, pagination: Pageable): Page<Category>

    @Query(value = "SELECT * FROM tb_category c WHERE c.name = ?1", nativeQuery = true)
    fun findByNameCategory(nameCategory: String): Category
}
