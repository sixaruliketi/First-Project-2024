package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentProfileBinding
import com.example.myapplication.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {

    private var _binding : FragmentProfileBinding ?= null
    private val binding get() = _binding!!

    private val db = FirebaseDatabase.getInstance().getReference("User")

    private val auth = FirebaseAuth.getInstance()

    private lateinit var controller: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init(){
        binding.apply {

            controller = findNavController()

            db.child(auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userInfo = snapshot.getValue(User::class.java) ?: return

                    Glide.with(this@ProfileFragment).load(userInfo.avatar).into(profileUserAvatarImageView)
                    profileUsernameTextView.text = userInfo.username

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }

            })

            profileEditInfoBtn.setOnClickListener {
                val userAvatar = profileUserAvatarET.text.toString()
                val username = profileUsernameET.text.toString()

                val userInfo = User(userAvatar, username)

                db.child(auth.currentUser!!.uid).setValue(userInfo)
            }

            profileGoBackBtn.setOnClickListener {
                val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                controller.navigate(action)
            }

        }

    }

}