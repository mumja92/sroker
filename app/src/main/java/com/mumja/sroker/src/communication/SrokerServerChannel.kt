package com.mumja.sroker.src.communication

import android.util.Log
import com.mumja.sroker.src.Player
import com.mumja.sroker.src.PlayerWrapperChannel
import com.mumja.sroker.src.communication.message.Message
import com.mumja.sroker.src.communication.message.MessageFactory
import com.mumja.sroker.src.communication.message.MessageType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SrokerServerChannel (
    private val channelServer: Channel<Message>,
    private val channels: MutableList<Channel<Message>>,
        ) : ISrokerServer{
    private var clientLogging : Int? = null
    private val players = mutableListOf<PlayerWrapperChannel>()

    override fun run() {
        GlobalScope.launch{
            while (true){
                for (player in players){
                    sendMessage(player.player.id, MessageFactory.get(MessageType.TEST, "dupa"))
                }
                delay(3000L)
            }
        }
        GlobalScope.launch{
            while (true){
                val messageReturn = channelServer.receive()
                Log.i("SROKER", "[Server][" + messageReturn.id + "] received '" + messageReturn.type.toString() + ","+ messageReturn.argument+ "'")
                when (messageReturn.type){
                    MessageType.START_GAME -> {
                        startGame()
                    }
                    MessageType.ACK -> {
                    }
                    MessageType.REGISTER_PLAYER -> {
                        val newPlayerId = messageReturn.argument.toInt()
                        players.add(PlayerWrapperChannel(Player(newPlayerId), newPlayerId))
                        sendMessage(newPlayerId, MessageFactory.get(MessageType.REGISTER_PLAYER, newPlayerId.toString()))
                    }
                    else -> {
                    }
                }
            }
        }

    }

    private fun startGame(){
    }

    private fun sendMessage(playerId: Int, message: Message){
        GlobalScope.launch{
                Log.i("SROKER", "[Server][" + message.id + "] sending '" + message.type.toString() + "," + message.argument + "' to player " + playerId)
                channels[playerId].send(message)
        }
    }
}