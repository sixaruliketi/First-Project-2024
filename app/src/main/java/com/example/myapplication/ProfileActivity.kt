package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    private val auth = FirebaseAuth.getInstance()
    private val auth2 = Firebase.auth

    private val db = FirebaseDatabase.getInstance().getReference("User")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

//            profileUsernameTV.text = auth.uid

            db.child(auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userInfo = snapshot.getValue(User::class.java) ?: return
                    Glide.with(this@ProfileActivity).load(userInfo.avatarLink).into(profileAvatarIV)
                    profileUsernameTV.text = userInfo.username
                    profileUidTV.text = userInfo.uid
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@ProfileActivity, "$error", Toast.LENGTH_SHORT).show()
                }

            })


            profileSaveBtn.setOnClickListener {

                val avatarLink = profileLinkToPhotoET.text.toString()
                val username = profileUsernameET.text.toString()
                val uid = auth.currentUser!!.uid

                val userInfo = User(uid, avatarLink, username)

                db.child(uid).setValue(userInfo)

            }

            signOutBtn.setOnClickListener {
                auth2.signOut()
                startActivity(Intent(this@ProfileActivity, SignInActivity::class.java))
                finish()
            }

            profileChangePasswordBtn.setOnClickListener {
                startActivity(Intent(this@ProfileActivity,ChangePasswordActivity::class.java))
            }

        }

    }
}