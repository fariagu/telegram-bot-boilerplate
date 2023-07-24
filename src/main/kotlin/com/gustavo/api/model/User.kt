package com.gustavo.api.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.Instant

@Entity(name = "habit_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private val id: Long? = null,
    private val username: String,
    private val firstname: String? = null,
    @Column(name = "chat_id")
    private val chatId: Int,
    @Column(name = "created_at")
    private val createdAt: Instant = Instant.now(),
    @Column(name = "updated_at")
    private val updatedAt: Instant = Instant.now(),
//    @OneToMany(mappedBy = "user")
//    private val habits: List<Habit>? = null,
)
