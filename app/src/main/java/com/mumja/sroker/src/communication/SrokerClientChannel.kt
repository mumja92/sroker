package com.mumja.sroker.src.communication

import android.util.Log
import com.mumja.sroker.src.communication.message.Message
import com.mumja.sroker.src.communication.message.MessageFactory
import com.mumja.sroker.src.communication.message.MessageType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SrokerClientChannel(
    private val channelServer: Channel<Message>,
    private val channelIn: Channel<Message>,
    private val channelId: Int
) : ISrokerClient{
    init {
        GlobalScope.launch {
            val message = MessageFactory.get(MessageType.REGISTER_PLAYER, channelId.toString())
            channelServer.send(message)
            Log.i("SROKER", "[Player" + channelId.toString() + "][" + message.id + "] sending '" + message.type.toString() + "," + message.argument + "'")
        }
    }
    override suspend fun getMessage(): Message {
        val message = channelIn.receive()
        Log.i("SROKER", "[Player" + channelId.toString() + "][" + message.id + "] received '" + message.type.toString() + "," + message.argument + "'")
        val messageReturn = MessageFactory.get(MessageType.ACK, message.id.toString())
        channelServer.send(messageReturn)
        Log.i("SROKER", "[Player" + channelId.toString() + "][" + messageReturn.id + "] sending '" + messageReturn.type.toString() + "," + messageReturn.argument + "'")
        return message
    }
}