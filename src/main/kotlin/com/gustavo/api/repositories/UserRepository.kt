package com.gustavo.api.repositories

import com.gustavo.api.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByChatId(chatId: Int): User?
}