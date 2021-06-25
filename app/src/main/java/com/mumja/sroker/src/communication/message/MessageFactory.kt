package com.mumja.sroker.src.communication.message

class MessageFactory {
    companion object{
        private var id = 0
        fun get(messageType: MessageType, argument: String): Message{
            return Message(id++, messageType, argument)
        }
    }
}