package com.mumja.sroker

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class RectangleDrawingScheme {
    companion object{
        private var paint = Paint()
        fun drawRectangle (canvas: Canvas, posX: Float, posY: Float, width: Float, height: Float){
            paint.color = Color.BLACK
            canvas.drawRect(posX, posY, width, height, paint)
            paint.color = Color.BLUE
            canvas.drawRect(posX+1, posY+1, width-1, height-1, paint)
        }
    }
}