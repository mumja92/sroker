package com.mumja.sroker.src.communication.message

enum class MessageType {
    TEST,
    // message received, no parameters
    ACK,
    // client asks server to start game (no more waiting for players), no parameters
    START_GAME,
    // 1. client asks server to register player, no parameters
    // 2. server returns with playerId number
    // playerId is used to distinguish which channel to use
    REGISTER_PLAYER,
}