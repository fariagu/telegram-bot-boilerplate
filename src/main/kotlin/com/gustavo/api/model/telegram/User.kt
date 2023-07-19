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
    @JsonProperty("language_code")
    val languageCode: String?,
    @JsonProperty("is_premium")
    val isPremium: Boolean?,
    @JsonProperty("added_to_attachment_menu")
    val addedToAttachmentMenu: Boolean?,
    @JsonProperty("can_join_groups")
    val canJoinGroups: Boolean?,
    @JsonProperty("can_read_all_group_messages")
    val canReadAllGroupMessages: Boolean?,
    @JsonProperty("supports_inline_queries")
    val supportsInlineQueries: Boolean?,
)