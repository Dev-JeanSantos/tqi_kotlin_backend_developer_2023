package com.tqi.challenge.backend.marketplace.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}