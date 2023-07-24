package com.gustavo.api.services.user

import com.gustavo.api.model.User
import com.gustavo.api.repositories.UserRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUser(chatId: Int) : User? = userRepository.findByChatId(chatId)

    fun createUser(chatId: Int, username: String, firstname: String, lastname: String) : User =
        userRepository.save(
            User(
                username = username,
                firstname = firstname,
                chatId = chatId,
                createdAt = Instant.now(),
                updatedAt = Instant.now(),
            )
        )
}