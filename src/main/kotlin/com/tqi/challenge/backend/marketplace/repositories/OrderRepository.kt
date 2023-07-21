package com.tqi.challenge.backend.marketplace.repositories

import com.tqi.challenge.backend.marketplace.entities.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
}
