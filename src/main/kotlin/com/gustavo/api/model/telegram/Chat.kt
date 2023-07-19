package com.gustavo.api.model.telegram

import com.fasterxml.jackson.annotation.JsonProperty

data class Chat(
    val id: Int,
    val type: String,
    val username: String?,
    @JsonProperty("first_name")
    val firstName: String?,
    @JsonProperty("last_name")
    val lastName: String?,
)