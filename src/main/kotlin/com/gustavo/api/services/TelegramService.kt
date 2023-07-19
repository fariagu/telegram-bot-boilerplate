package com.gustavo.api.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

@Service
class TelegramService(
    @Value("\${telegram.token}")
    private val token: String,
    private val restTemplate: RestTemplate
) {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TelegramService::class.java)
        const val BASE_URL = "https://api.telegram.org/bot"
    }

    fun sendMessage(text: String, chatId: Int) {
        val url = "$BASE_URL$token/sendMessage"

        try {
            restTemplate.postForObject<Unit>(
                url,
                mapOf(
                    "chat_id" to chatId,
                    "text" to text,
                )
            )
        } catch (e: RestClientException) {
            logger.error("Error sending message to Telegram:\n$e")
        }
    }
}