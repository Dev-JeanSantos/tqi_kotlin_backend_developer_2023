package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_cart")
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true) var id: Long? = null,
    @ManyToOne
    var product: Product?,
    val quantityItens: Int,
    val priceBySale: Double,

    @OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
    var orders: List<Order>? = ArrayList()
)
