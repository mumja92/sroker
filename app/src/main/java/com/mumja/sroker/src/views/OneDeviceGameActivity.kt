package com.mumja.sroker.src.views

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mumja.sroker.R


class OneDeviceGameActivity : AppCompatActivity() {
    private var buttonStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lobby_one_device_view)
        buttonStart = findViewById(R.id.buttonMainStart)
        buttonStart?.setOnClickListener{
            setContentView(SrokerView(this, 2))
        }
    }
}