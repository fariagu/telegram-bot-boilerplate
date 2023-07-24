package com.gustavo.api.commands

import com.gustavo.api.model.User

data class NewHabitCommand(
    val user: User,
    val name: String,
    val frequency: String,
)
