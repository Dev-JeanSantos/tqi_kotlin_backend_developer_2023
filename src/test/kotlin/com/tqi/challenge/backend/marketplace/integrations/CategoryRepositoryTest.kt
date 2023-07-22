package com.tqi.challenge.backend.marketplace.integrations

import com.tqi.challenge.backend.marketplace.mocks.BuildCategory
import com.tqi.challenge.backend.marketplace.repositories.CategoryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import com.tqi.challenge.backend.marketplace.entities.Category as Category

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    private val nameCategory = "PAPELARIA"

    private val category = BuildCategory.buildCategory()

    companion object{
        @Container
        private val mysqlContainer =  MySQLContainer<Nothing>("mysql:8.0.28").apply {
            withDatabaseName("testedb")
            withUsername("teste")
            withPassword("123456")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry){
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
        }
    }

    @Test
    fun `should return a category`(){

        categoryRepository.save(category)
        val category = categoryRepository.findByNameCategory(nameCategory)

        assertThat(category).isNotNull
        assertThat(category).isExactlyInstanceOf(Category::class.java)
    }

    @Test
    fun `should return a category by name`(){

        categoryRepository.save(category)
        val category = categoryRepository.findByName(nameCategory,PageRequest.of(0, 1))
        assertThat(category).isNotNull
    }
}