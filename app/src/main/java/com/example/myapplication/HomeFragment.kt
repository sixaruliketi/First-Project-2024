package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var controller: NavController

    private lateinit var nextBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextBtn = view.findViewById(R.id.nextBtn)


        controller = Navigation.findNavController(view)

        nextBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            controller.navigate(action)
        }
    }
}