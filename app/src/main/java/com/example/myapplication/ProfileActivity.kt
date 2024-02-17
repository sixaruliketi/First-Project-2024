package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    private val auth = FirebaseAuth.getInstance()
    private val auth2 = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            profileDetailsTV.text = auth.uid

            signOutBtn.setOnClickListener {
                auth2.signOut()
                startActivity(Intent(this@ProfileActivity, SignInActivity::class.java))
                finish()
            }

            profileChangePasswordBtn.setOnClickListener {
                startActivity(Intent(this@ProfileActivity,ChangePasswordActivity::class.java))
            }

        }

    }
}