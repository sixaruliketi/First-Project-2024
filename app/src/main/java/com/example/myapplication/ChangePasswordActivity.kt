package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityChangePasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            changePasswordBtn.setOnClickListener {
                val newPassword = changePasswordET.text.toString()

                if (newPassword.isEmpty()){
                    Toast.makeText(this@ChangePasswordActivity, "error!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)?.addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this@ChangePasswordActivity, ProfileActivity::class.java))
                        finish()
                    }
                }
            }

        }
    }
}