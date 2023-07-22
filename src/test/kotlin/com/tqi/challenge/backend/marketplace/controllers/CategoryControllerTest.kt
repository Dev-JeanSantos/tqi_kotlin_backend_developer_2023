package com.tqi.challenge.backend.marketplace.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.tqi.challenge.backend.marketplace.dtos.requesties.CategoryRequestDTO
import com.tqi.challenge.backend.marketplace.mocks.BuildCategoryDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@ContextConfiguration
class CategoryControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    companion object {
        const val URL: String = "/api/v1/marketing/categories"
    }

    @Test
    fun `should create a category and return 201 status`() {
        val dto: CategoryRequestDTO = BuildCategoryDto.buildCategoryDto()
        val dtoConverterString: String = objectMapper.writeValueAsString(dto)

        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(dtoConverterString)
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bebidas"))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not save category with empty name and return status 400`() {

        val categoryRequestDTO  = BuildCategoryDto.buildCategoryDto(name = "")
        println(categoryRequestDTO)
        val valueAsString: String = objectMapper.writeValueAsString(categoryRequestDTO)
        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .content(valueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("{name=Required field}"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("INTERNAL_SERVER_ERROR"))
            .andDo(MockMvcResultHandlers.print())
    }
    @Test
    fun `should not save a category with less than 3 characters in the name and return 400 status`() {

        val categoryRequestDTO  = BuildCategoryDto.buildCategoryDto(name = "de")
        println(categoryRequestDTO)
        val valueAsString: String = objectMapper.writeValueAsString(categoryRequestDTO)
        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .content(valueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("{name=Field requires 3 to 30 characters}"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("INTERNAL_SERVER_ERROR"))
            .andDo(MockMvcResultHandlers.print())
    }
}