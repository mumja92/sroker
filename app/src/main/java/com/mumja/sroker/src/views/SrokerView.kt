package com.mumja.sroker.src.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.mumja.sroker.src.communication.*
import com.mumja.sroker.src.communication.message.Message
import com.mumja.sroker.src.communication.message.MessageType
import com.mumja.sroker.src.drawers.ObjectDrawer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class SrokerView(
    c: Context?,
    private var numberOfPlayers: Int,
) : View(c) {
    private val myPaint = Paint()
    private var locationX = 0F
    private var locationY = 0F
    private var srokerClient : ISrokerClient? = null
    private var srokerServer : ISrokerServer? = null
    private val serverChannel = Channel<Message>()
    private val channels = mutableListOf<Channel<Message>>()
    private var maxPlayers = 10

        init {
            for (i in 1..maxPlayers){
                val channel = Channel<Message>()
                channels.add(channel)
            }
            myPaint.color = Color.rgb(0, 255, 0)
            myPaint.strokeWidth = 10F
            startServerChannel()
            srokerServer?.run()
            GlobalScope.launch{
                while(true){
                    val message = srokerClient!!.getMessage()
                    Log.i("SROKER", "View parsing: MessageId: " + message.id + ","+ message.type.toString())
                    when(message.type){
                        MessageType.TEST -> {
                            locationX = (0..500).random().toFloat()
                            locationY = (0..500).random().toFloat()
                            invalidate()
                        }
                        else -> {

                        }
                    }
                }

            }
        }
    override fun onDraw(canvas: Canvas) {
        drawView(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                touchStart(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                touchMove(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                touchEnd()
                invalidate()
            }
        }
        return true
    }


    private fun touchStart(x: Float, y: Float) {
        locationX = x
        locationY = y
    }

    private fun touchMove(x: Float, y: Float) {
        locationX = x
        locationY = y
    }

    private fun touchEnd() {
    }

    private fun drawView(canvas: Canvas){
        drawCardCentered(canvas, locationX, locationY, 200F, 200F)
    }

    private fun drawCardCentered(canvas: Canvas, x: Float, y: Float, sizeX: Float, sizeY: Float){
        ObjectDrawer.drawCard(canvas, x - sizeX / 2, y - sizeY / 2, x + sizeX / 2, y + sizeY / 2)
    }

    private fun startServerChannel(){
        srokerServer = SrokerServerChannel(serverChannel, channels)
        srokerClient = SrokerClientChannel(serverChannel, channels[2], 2)
    }
}