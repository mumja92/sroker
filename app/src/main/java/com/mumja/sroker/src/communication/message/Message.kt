package com.mumja.sroker.src.communication.message

data class Message(
    val id: Int,
    val type: MessageType,
    val argument: String,
)
