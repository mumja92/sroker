package com.mumja.sroker.src.state

enum class UserState {
    STATE0_NON_REGISTERED,  // starting state; in this state ask server to join the game
    STATE1_GAME_ACCEPTED,   // server accepted, waiting for 2 cards and entering state2 after
    STATE2_GAME,            // cards received, waiting for turn or state3 request
    STATE3_GAME,            // state2 started, 3 cards showed, waiting for turn or state4 request
    STATE4_GAME,            // state3 started, 5 cards showed, waiting for turn or state5 request
    STATE5_RESULTS,         // showing summary, waiting for state1 request
    STATE_PASS              // passed, waiting for state5 request
}