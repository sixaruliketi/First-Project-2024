package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            forgotPasswordSendBtn.setOnClickListener {

                val email = forgotPasswordEmailET.text.toString()

                if (email.isEmpty()){
                    Toast.makeText(this@ForgotPasswordActivity, "error!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this@ForgotPasswordActivity,SignInActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@ForgotPasswordActivity, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }

    }
}