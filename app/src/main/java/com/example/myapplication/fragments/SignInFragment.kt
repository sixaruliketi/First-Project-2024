package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.HomeActivity
import com.example.myapplication.databinding.FragmentSignInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


class SignInFragment : Fragment(){

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val auth = Firebase.auth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            signInBtn.setOnClickListener {
                val email = signInEmailET.text.toString()
                val password = signInPasswordET.text.toString()

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(context, "email or password is empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "signed in", Toast.LENGTH_SHORT).show()
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