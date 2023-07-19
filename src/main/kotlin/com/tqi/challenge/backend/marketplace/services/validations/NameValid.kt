package com.tqi.challenge.backend.marketplace.services.validations

import jakarta.validation.*
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NameValidator::class])
@MustBeDocumented
annotation class NameValid (
    val message: String = "Validation error",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)