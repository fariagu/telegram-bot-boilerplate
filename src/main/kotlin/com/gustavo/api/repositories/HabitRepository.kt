package com.gustavo.api.repositories

import com.gustavo.api.model.Habit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HabitRepository : CrudRepository<Habit, Long> {
}