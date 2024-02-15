package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityItemZoomBinding

class ItemZoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemZoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textView1.text = intent.extras?.getString("TITLE")
            textView2.text = intent.extras?.getString("DETAILS")
        }

    }
}