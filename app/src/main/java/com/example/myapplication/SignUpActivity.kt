package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignupBinding

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            signupRegisterBtn.setOnClickListener {
                val email = signupEmailET.text.toString()
                val password = signupPasswordET.text.toString()

                if (email.isEmpty() || password.isEmpty() || password.length < 5 || password.contains(' ')){
                    Toast.makeText(this@SignUpActivity, "error!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this@SignUpActivity, "user is successfully created!", Toast.LENGTH_SHORT).show()
                        goToSignIn()
                    } else {
                        Toast.makeText(this@SignUpActivity, "error!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            signupSignInBtnTV.setOnClickListener {
                goToSignIn()
            }
        }
    }

    private fun goToSignIn(){
        startActivity(Intent(this@SignUpActivity,SignInActivity::class.java))
        finish()
    }

}