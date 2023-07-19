package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_category")
data class Category(
    @Column(nullable = false) var name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true) var id: Long? = null,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val products: List<Product>? = ArrayList()
)
