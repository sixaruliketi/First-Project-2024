package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var noteEditText: EditText
    private lateinit var enterBtn: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteEditText = findViewById(R.id.stringEditText)
        enterBtn = findViewById(R.id.enterBtn)
        textView = findViewById(R.id.textView)

        val sharedPreferences = getSharedPreferences("MY_NOTES", MODE_PRIVATE)
        val notes = sharedPreferences.getString("NOTE","")
        textView.text = notes

        enterBtn.setOnClickListener {
            val note = noteEditText.text.toString()
            val text = textView.text.toString()
            val result = note + "\n" + text

            textView.text = result
            noteEditText.setText("")

            sharedPreferences.edit().putString("NOTE",result).apply()

        }

    }

}