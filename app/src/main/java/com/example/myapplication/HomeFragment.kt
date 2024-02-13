package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var controller : NavController

    lateinit var profileButton : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileButton = view.findViewById(R.id.profileButton)

        controller = Navigation.findNavController(view)

        profileButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            controller.navigate(action)

        }
    }

}