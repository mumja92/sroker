package com.mumja.sroker

import android.os.AsyncTask
import android.view.View

open class SrokerEngine(val context: View, var gameStatusReference: GameStatus, var touchLocation: InputData): AsyncTask<String, Void, String>() {
    private val timer = Timer(1000,50)
    private var nextTick = false
//    private val boardSupervisor = BoardSupervisor()
//    private val inputParser = InputParser()
//    var input = InputCommand.NONE

    override fun doInBackground(vararg p0: String?): String {
        while (true) {
            try {
//                input = inputParser.parseInput(touchLocation)
//                boardSupervisor.nextFrame(input, nextTick)
                fillGameStatus()
                publishProgress()
                nextTick = timer.handleTime()
            }
            catch (e: ExceptionGameOver){
                callGameOver()
                break
            }

        }
        return "placeholder"
    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
        context.invalidate()
    }

    private fun callGameOver(){
    }

    private fun fillGameStatus(){
    }
}