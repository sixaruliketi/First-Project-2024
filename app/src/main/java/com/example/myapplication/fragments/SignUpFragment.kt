package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.HomeActivity
import com.example.myapplication.databinding.FragmentSignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpFragment : Fragment(){
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val auth = Firebase.auth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            signUpBtn.setOnClickListener {
                val email = signUpEmailET.text.toString()
                val password = signUpPasswordET.text.toString()

                if (email.isEmpty() || password.isEmpty() || password.contains(' ') || password.length < 5 || !email.contains('@')){
                    Toast.makeText(context, "email or password is empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "signed up", Toast.LENGTH_SHORT).show()
                        goToHome()
                    } else {
                        Toast.makeText(context, "${it.exception}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun goToHome(){
        val intent = Intent(activity, HomeActivity::class.java)
        activity?.startActivity(intent)
        activity?.finish()
    }
}
