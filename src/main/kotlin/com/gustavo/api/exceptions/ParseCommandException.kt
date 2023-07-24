package com.gustavo.api.exceptions

class ParseCommandException(
    override val message: String
) : Exception(message)