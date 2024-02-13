package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ProfileFragment :Fragment(R.layout.fragment_profile) {

    lateinit var backButton: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton = view.findViewById(R.id.backButton)

        val controller = Navigation.findNavController(view)

        backButton.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
            controller.navigate(action)
        }
    }

}