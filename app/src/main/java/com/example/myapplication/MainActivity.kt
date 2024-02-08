package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.math.log
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.userNameEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val button = findViewById<Button>(R.id.loginButton)

        button.setOnClickListener {
            val username1 = username.text.toString()
            val password1 = password.text.toString()

            val intent = Intent(this,MainActivity2::class.java)

            intent.putExtra("USERNAME",username1)
            intent.putExtra("PASSWORD",password1)

            startActivity(intent)
        }

//        Log.d("myTag", "OnCreate")
    }


//    override fun onStart() {
//        super.onStart()
//        Log.d("myTag", "OnStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("myTag", "OnResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("myTag", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("myTag", "OnStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("myTag", "onDestroy")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("myTag", "onRestart")
//    }

}