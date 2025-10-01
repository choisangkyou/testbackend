package com.example.com.example.demo.controller

import com.example.com.example.demo.entity.User
import com.example.com.example.demo.serive.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun create(@RequestBody dto: UserDto): User = userService.createUser(dto.name, dto.email)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): User? = userService.getUser(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: UserDto): User? =
        userService.updateUser(id, dto.name, dto.email)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = userService.deleteUser(id)

    @GetMapping
    fun list(): List<User> = userService.findAll()
}

data class UserDto(val name: String, val email: String)