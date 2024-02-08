package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        findViewById<TextView>(R.id.textView1).text = intent.extras?.getString("USERNAME")
        findViewById<TextView>(R.id.textView2).text = intent.extras?.getString("PASSWORD")
        findViewById<TextView>(R.id.textView3).text = intent.extras?.getInt("NUMBER",0).toString()

    }
}