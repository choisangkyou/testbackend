package com.example.demo.controller

import com.example.demo.config.HelloController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(HelloController::class)
class HelloControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `GET hello returns Hello message`() {
        // when & then
        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello from Backend!"))
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
    }

    @Test
    fun `GET hello returns correct HTTP status`() {
        // when & then
        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk)
    }

    @Test
    fun `GET nonexistent endpoint returns 404`() {
        // when & then
        mockMvc.perform(get("/nonexistent"))
            .andExpect(status().isNotFound)
    }
}