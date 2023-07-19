package com.gustavo.api.model.telegram

import com.fasterxml.jackson.annotation.JsonProperty

data class Message(
    @JsonProperty("message_id")
    val messageId: Int,
    @JsonProperty("message_thread_id")
    val messageThreadId: Int,
    val from: User,
    val date: Int,
    val chat: Chat,
    val text: String?,
)