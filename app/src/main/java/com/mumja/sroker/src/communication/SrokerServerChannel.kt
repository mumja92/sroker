package com.mumja.sroker.src.communication

import com.mumja.sroker.src.communication.message.Message
import com.mumja.sroker.src.communication.message.MessageFactory
import com.mumja.sroker.src.communication.message.MessageType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SrokerServerChannel (
    private val channelIn: Channel<Message>,
    private val channelOut: Channel<Message>,
        ) : ISrokerServer{
    override fun run() {
        GlobalScope.launch{
            while (true){
                channelOut.send(MessageFactory.get(MessageType.TEST, ""))
                val messageReturn = channelIn.receive()
                delay(3000L)
            }
        }

    }
}