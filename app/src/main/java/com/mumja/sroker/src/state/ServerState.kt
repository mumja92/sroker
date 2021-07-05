package com.mumja.sroker.src.state

enum class ServerState {
    STATE0_WAITING_FOR_PLAYERS, // server accepts new players
    STATE1_GAME_START,          // give everyone 2 cards
    STATE2_GAME,                // sending requests for turns until bidding ends
    STATE3_GAME,                // showing 3 cards and sending requests for turns until bidding ends
    STATE4_GAME,                // showing 5 cards and sending requests for turns until bidding ends
    STATE5_RESULTS,             // sending results and going back to state1
}