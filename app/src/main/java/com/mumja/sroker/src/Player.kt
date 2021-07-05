package com.mumja.sroker.src

import com.mumja.sroker.src.communication.message.Message
import kotlinx.coroutines.channels.Channel

data class Player(
    var id: Int,
    var points: Int = 0,
    )
