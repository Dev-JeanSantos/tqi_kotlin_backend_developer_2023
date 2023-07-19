package com.tqi.challenge.backend.marketplace.services.validations

import com.tqi.challenge.backend.marketplace.configs.FieldMessage
import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.repositories.CategoryRepository
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


class NameValidator(
    val repository: CategoryRepository
) : ConstraintValidator<NameValid, CategoryRequestDTO> {
    override fun isValid(value: CategoryRequestDTO?, context: ConstraintValidatorContext?): Boolean {

        var list: List<FieldMessage> = ArrayList<FieldMessage>()

        val category = repository.findByName(value!!.name)
        if (category != null) {
            listOf(FieldMessage("Name", "Name not found!"))
        }
        for (FieldMessage in list) {
            context?.disableDefaultConstraintViolation()
            context?.buildConstraintViolationWithTemplate(FieldMessage.message)
                ?.addPropertyNode(FieldMessage.fieldName)?.addConstraintViolation()
        }
        return list.isEmpty()
    }
}
