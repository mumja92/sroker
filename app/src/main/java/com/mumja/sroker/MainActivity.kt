package com.mumja.sroker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mumja.sroker.src.views.SrokerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SrokerView(this))
    }
}