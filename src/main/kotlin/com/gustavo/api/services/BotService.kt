package com.gustavo.api.services

import com.gustavo.api.model.Habit
import com.gustavo.api.model.telegram.Update
import com.gustavo.api.services.habit.HabitService
import com.gustavo.api.services.user.UserService
import com.gustavo.api.util.ParseCommand
import org.springframework.stereotype.Service

@Service
class BotService(
    private val telegramService: TelegramService,
    private val userService: UserService,
    private val habitService: HabitService,
) {
    companion object {
        const val COMMAND1 = "/command1"
        const val COMMAND2 = "/command2"
        // /new-habit <name> <frequency>
        const val NEW_HABIT = "/new-habit"
    }

    fun processMessage(update: Update) {
        val message = update.message!!
        val user = userService.getUser(message.chat.id) ?: run {
            userService.createUser(
                message.chat.id,
                message.from.username!!,
                message.from.firstName,
                message.from.lastName!!,
            )
        }

        message.text!!.let { command ->
            when {
                command.startsWith(NEW_HABIT) -> {
                    val habit = habitService.createHabit(ParseCommand.newHabit(command, user))
                    telegramService.sendMessage("Habit created: $habit", message.chat.id)
                }
                command.startsWith(COMMAND1) -> telegramService.sendMessage("Command 1 received", message.chat.id)
                command.startsWith(COMMAND2) -> telegramService.sendMessage("Command 2 received", message.chat.id)
                else -> telegramService.sendMessage("Command not found", message.chat.id)
            }
        }
    }
}