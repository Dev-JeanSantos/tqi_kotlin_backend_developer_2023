package com.tqi.challenge.backend.marketplace.entities

import com.tqi.challenge.backend.marketplace.enums.Payment
import jakarta.persistence.*

@Entity
@Table(name = "tb_order")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    var id: Long? = null,
    var totalSalePrice: Double,
    @Enumerated(EnumType.STRING)
    var payment: Payment
)
