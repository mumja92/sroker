package com.mumja.sroker.src.drawers

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class ObjectDrawer {
    companion object{
        private var paint = Paint()
        fun drawCard (canvas: Canvas, posX: Float, posY: Float, width: Float, height: Float){
            paint.color = Color.WHITE
            canvas.drawRect(posX, posY, width, height, paint)
            paint.color = Color.BLUE
            canvas.drawRect(posX+1, posY+1, width-1, height-1, paint)
        }
    }
}