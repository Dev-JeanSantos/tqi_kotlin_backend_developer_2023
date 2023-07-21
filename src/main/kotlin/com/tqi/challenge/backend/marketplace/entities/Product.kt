package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true) var id: Long? = null,
    @Column(nullable = false) var name: String,
    @Column(nullable = false) var unitMeasure: String,
    @Column(nullable = false) var price: Double,

    @ManyToOne
    var category: Category,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    var items: List<Item>? = ArrayList()
)
