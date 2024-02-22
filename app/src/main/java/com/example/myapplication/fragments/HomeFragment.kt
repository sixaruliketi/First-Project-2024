package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.adapters.HomeRecyclerViewAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Post
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter

    private val auth = Firebase.auth

    private lateinit var dbref : DatabaseReference

    private lateinit var postArrayList : ArrayList<Post>

    private lateinit var controller : NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {

            controller = findNavController()

            homeRecyclerView.layoutManager = LinearLayoutManager(context)
            homeRecyclerView.setHasFixedSize(true)

            postArrayList = arrayListOf<Post>()
            homeRecyclerViewAdapter = HomeRecyclerViewAdapter(postArrayList)
            getPostData()

            homeRecyclerViewAdapter.onClick = {
                Toast.makeText(context, "liked", Toast.LENGTH_SHORT).show()
            }

            homeLogOutBtn.setOnClickListener {
                auth.signOut()
                val intent = Intent(activity, MainActivity::class.java)
                activity?.startActivity(intent)
                activity?.finish()
            }

            menuBtn.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                controller.navigate(action)
            }
        }
    }

    private fun getPostData() {

        postArrayList.clear()
        dbref = FirebaseDatabase.getInstance().getReference("Post")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (postSnapshot in snapshot.children) {
                        val user = postSnapshot.getValue(Post::class.java)
                        postArrayList.add(user!!)
                    }

                    binding.homeRecyclerView.adapter = HomeRecyclerViewAdapter(postArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
            }

        })
    }

}