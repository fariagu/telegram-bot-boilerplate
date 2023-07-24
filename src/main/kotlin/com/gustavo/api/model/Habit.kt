package com.gustavo.api.model


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.Instant

@Entity
data class Habit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "user_id")
    private val user: User,
    private val name: String,
    private val frequency: Frequency,
    @Column(name = "created_at")
    private val createdAt: Instant = Instant.now(),
    @Column(name = "updated_at")
    private val updatedAt: Instant = Instant.now(),
)

enum class Frequency {
    TWICE_DAILY,
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY,
}