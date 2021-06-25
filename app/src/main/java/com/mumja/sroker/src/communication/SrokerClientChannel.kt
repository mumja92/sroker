package com.mumja.sroker.src.communication

import com.mumja.sroker.src.communication.message.Message
import com.mumja.sroker.src.communication.message.MessageFactory
import com.mumja.sroker.src.communication.message.MessageType
import kotlinx.coroutines.channels.Channel

class SrokerClientChannel(
    private val channelIn: Channel<Message>,
    private val channelOut: Channel<Message>,
) : ISrokerClient{
    override suspend fun getMessage(): Message {
        val message = channelIn.receive()
        channelOut.send(MessageFactory.get(MessageType.ACK, message.id.toString()))
        return message
    }
}