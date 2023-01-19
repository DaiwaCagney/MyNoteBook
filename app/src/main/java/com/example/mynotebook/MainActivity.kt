package com.example.mynotebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainButton : Button = findViewById(R.id.button)
        mainButton.setOnClickListener {
            startActivity(Intent(this, NoteMain::class.java))
        }
    }
}