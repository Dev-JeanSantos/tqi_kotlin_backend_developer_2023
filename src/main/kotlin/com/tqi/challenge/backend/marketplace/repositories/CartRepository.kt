package com.tqi.challenge.backend.marketplace.repositories

import com.tqi.challenge.backend.marketplace.entities.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : JpaRepository<Cart, Long> {
}
