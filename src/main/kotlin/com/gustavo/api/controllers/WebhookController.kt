package com.gustavo.api.controllers

import com.gustavo.api.model.telegram.Update
import com.gustavo.api.services.BotService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebhookController(
    private val botService: BotService
) {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(WebhookController::class.java)
    }

    @PostMapping
    fun getUpdate(@RequestBody body: Update): ResponseEntity<Update> {
        logger.info("Update received: $body")
        botService.processMessage(body)
        return ResponseEntity.ok(body)
    }

    @GetMapping("/ok")
    fun ok(): ResponseEntity<Any> {
        return ResponseEntity.ok(object {
            val status = "ok"
        })
    }
}