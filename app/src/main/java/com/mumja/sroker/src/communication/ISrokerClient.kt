package com.mumja.sroker.src.communication

import com.mumja.sroker.src.communication.message.Message

interface ISrokerClient {
    suspend fun getMessage(): Message
}