package com.gustavo.api.services

import com.gustavo.api.model.telegram.Update
import org.springframework.stereotype.Service

@Service
class BotService(
    private val telegramService: TelegramService,
) {
    companion object {
        const val COMMAND1 = "/command1"
        const val COMMAND2 = "/command2"
    }

    fun processMessage(update: Update) {
        when(update.message!!.text) {
            COMMAND1 -> telegramService.sendMessage("Command 1 received", update.message.chat.id)
            COMMAND2 -> telegramService.sendMessage("Command 2 received", update.message.chat.id)
            else -> telegramService.sendMessage("Command not found", update.message.chat.id)
        }
    }
}