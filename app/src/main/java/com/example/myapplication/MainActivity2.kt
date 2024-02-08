package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val showUserName = findViewById<TextView>(R.id.showUserNameTV)
        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        val username = intent.extras?.getString("USERNAME", "rame")
        showUserName.text = username

        nextButton.setOnClickListener {
            val number = numberEditText.text.toString().toInt()
            val password = intent.extras?.getString("PASSWORD")

            val intent = Intent(this, MainActivity3::class.java)

            intent.putExtra("USERNAME", username)
            intent.putExtra("PASSWORD",password)
            intent.putExtra("NUMBER", number)

            startActivity(intent)


        }


    }
}