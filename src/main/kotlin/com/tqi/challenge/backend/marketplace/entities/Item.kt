package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true) var id: Long? = null,
    @ManyToOne
    var product: Product?,
    val quantityItens: Int,
    val priceBySale: Double
)
