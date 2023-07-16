package com.tqi.challenge.backend.marketplace.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_category")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)
