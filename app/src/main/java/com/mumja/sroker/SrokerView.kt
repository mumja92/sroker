package com.mumja.sroker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class SrokerView(c: Context?) : View(c) {
    private val myPaint = Paint()
    private var locationX = 0F
    private var locationY = 0F

        init {
            myPaint.color = Color.rgb(0, 255, 0)
            myPaint.strokeWidth = 10F
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

    private fun drawCard(canvas: Canvas, x: Float, y: Float, sizeX: Float, sizeY: Float){
        canvas.drawRect(x, y, x+sizeX, y+sizeY, myPaint)
    }
    private fun drawCardCentered(canvas: Canvas, x: Float, y: Float, sizeX: Float, sizeY: Float){
        canvas.drawRect(x-sizeX/2, y-sizeY/2, x+sizeX/2, y+sizeY/2, myPaint)
    }
}