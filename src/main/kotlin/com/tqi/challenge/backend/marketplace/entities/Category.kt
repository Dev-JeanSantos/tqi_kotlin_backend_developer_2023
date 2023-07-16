package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_category")
data class Category(
    val name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
