package com.tqi.challenge.backend.marketplace.services.impl

import com.tqi.challenge.backend.marketplace.exceptions.NotFoundException
import com.tqi.challenge.backend.marketplace.mappers.CategoryMapper
import com.tqi.challenge.backend.marketplace.mappers.requests.CategoryRequestMapper
import com.tqi.challenge.backend.marketplace.mappers.responses.CategoryResponseMapper
import com.tqi.challenge.backend.marketplace.mappers.responses.CategoryResponsePaginationMapper
import com.tqi.challenge.backend.marketplace.mocks.BuildCategory
import com.tqi.challenge.backend.marketplace.mocks.BuildCategoryResponseDto
import com.tqi.challenge.backend.marketplace.repositories.CategoryRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
class CategoryServiceTest {

    val categories = PageImpl(listOf(BuildCategory.buildCategory()))

    private val paginaton: Pageable = mockk()

    private val categoryRequestMapper: CategoryRequestMapper = mockk()
    private val categoryResponseMapper: CategoryResponseMapper = mockk()
    private val categoryResponsePaginationMapper: CategoryResponsePaginationMapper = mockk()
    private val categoryMapper: CategoryMapper = mockk()

    private val categoryRepository: CategoryRepository = mockk {
        every { findByName(any(), any()) } returns categories
        every { findAll(paginaton) } returns categories
        every { categoryResponsePaginationMapper.map(any()) } returns BuildCategoryResponseDto.buildCategoryDto()
    }

    val categoryService = CategoryService(
        categoryRequestMapper,
        categoryResponseMapper,
        categoryResponsePaginationMapper,
        categoryMapper,
        categoryRepository
    )

    @Test
    fun `should return for a category by passing the category name`() {
        categoryService.getAll("PAPELARIA", paginaton)
        verify(exactly = 1) { categoryRepository.findByName(any(), any()) }
        verify(exactly = 1) { categoryResponsePaginationMapper.map(any()) }
        verify(exactly = 0) { categoryRepository.findAll(paginaton) }
    }

    @Test
    fun `should return all categories by not passing the name of the category`() {
        categoryService.getAll(null, paginaton)
        verify(exactly = 0) { categoryRepository.findByName(any(), any()) }
        verify(exactly = 1) { categoryResponsePaginationMapper.map(any()) }
        verify(exactly = 1) { categoryRepository.findAll(paginaton) }
    }

    @Test
    fun `should return a NotFoundException when the category id is not found`() {

        every { categoryRepository.findById(any()) } returns Optional.empty()

        val atual = assertThrows<NotFoundException> {
            categoryService.getCategoryById(3)
        }
        assertThat(atual.message, equalTo("Category by Id 3 Not Found"))
    }
}

