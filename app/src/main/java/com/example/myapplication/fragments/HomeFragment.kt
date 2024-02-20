package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.HomeRecyclerViewAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Post

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {

            homeRecyclerViewAdapter = HomeRecyclerViewAdapter(getData())
            homeRecyclerView.adapter = homeRecyclerViewAdapter
            homeRecyclerView.layoutManager = LinearLayoutManager(context)

            // TODO: onClick


        }
    }

    private fun getData(): MutableList<Post> {
        // TODO: get data from firebase realtime database
    }


}