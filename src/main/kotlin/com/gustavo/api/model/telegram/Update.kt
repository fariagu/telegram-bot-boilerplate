package com.gustavo.api.model.telegram

import com.fasterxml.jackson.annotation.JsonProperty

data class Update(
    @JsonProperty("update_id")
    val updateId: Int,
    val message: Message?,
)