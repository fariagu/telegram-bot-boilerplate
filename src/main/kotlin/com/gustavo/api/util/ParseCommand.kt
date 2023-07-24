package com.gustavo.api.util

import com.gustavo.api.commands.NewHabitCommand
import com.gustavo.api.exceptions.ParseCommandException
import com.gustavo.api.model.User

class ParseCommand {
    companion object {
        fun newHabit(command: String, user: User): NewHabitCommand {
            val words = command.split(" ")
            if (words.size != 3) {
                throw ParseCommandException("Wrong number of arguments for command /new_habit")
            }

            return NewHabitCommand(user, words[1], words[2])
        }
    }
}