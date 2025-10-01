package com.example.com.example.demo.serive

import com.example.com.example.demo.entity.User
import com.example.com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(name: String, email: String): User =
        userRepository.save(User(name = name, email = email))

    fun getUser(id: Long): User? = userRepository.findById(id).orElse(null)

    fun updateUser(id: Long, name: String, email: String): User? {
        val user = userRepository.findById(id).orElse(null) ?: return null
        user.name = name
        user.email = email
        return userRepository.save(user)
    }

    fun deleteUser(id: Long) = userRepository.deleteById(id)

    fun findAll(): List<User> = userRepository.findAll()
}