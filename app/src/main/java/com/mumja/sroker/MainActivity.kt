package com.mumja.sroker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mumja.sroker.src.views.OneDeviceGameActivity


class MainActivity : AppCompatActivity() {
    private var buttonStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_view)
        buttonStart = findViewById(R.id.buttonMainStart)
        buttonStart?.setOnClickListener{
            startActivity(Intent(this, OneDeviceGameActivity::class.java))
        }
    }
}