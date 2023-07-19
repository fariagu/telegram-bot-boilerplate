package com.gustavo.api.model.telegram

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    val id: Int,
    @JsonProperty("is_bot")
    val isBot: Boolean,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String?,
    val username: String?,
)