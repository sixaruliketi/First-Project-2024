package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            signInLogInBtn.setOnClickListener {
                val email = signInEmailET.text.toString()
                val password = signInPasswordET.text.toString()

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(this@SignInActivity, "error!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this@SignInActivity,ProfileActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@SignInActivity, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            signInSignUpBtnTV.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                finish()
            }
            signInForgotPasswordBtn.setOnClickListener {
                startActivity(Intent(this@SignInActivity,ForgotPasswordActivity::class.java))
            }
        }

    }


}