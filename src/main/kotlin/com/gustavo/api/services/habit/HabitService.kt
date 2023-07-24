package com.gustavo.api.services.habit

import com.gustavo.api.commands.NewHabitCommand
import com.gustavo.api.model.Frequency
import com.gustavo.api.model.Habit
import com.gustavo.api.repositories.HabitRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant

@Service
class HabitService(
    private val habitRepository: HabitRepository
) {
    fun createHabit(newHabit: NewHabitCommand): Habit =
        habitRepository.save(
            Habit(
                user = newHabit.user,
                name = newHabit.name,
                frequency = Frequency.valueOf(newHabit.frequency.uppercase()),
                createdAt = Instant.now(),
                updatedAt = Instant.now(),
            )
        )
}