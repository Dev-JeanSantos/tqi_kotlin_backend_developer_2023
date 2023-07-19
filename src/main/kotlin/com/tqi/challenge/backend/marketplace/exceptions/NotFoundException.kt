package com.tqi.challenge.backend.marketplace.exceptions

data class NotFoundException(override val message: String) : RuntimeException(message)