package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        binding.apply {
            viewPagerAdapter = ViewPagerAdapter(this@MainActivity)
            signUpSignInViewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabBar,signUpSignInViewPager) { tab, position ->
                when (position){
                    0 -> tab.setText("Sign In")
                    1 -> tab.setText("Sign Up")
                    else -> tab.setText("Sign In")
                }
            }.attach()
        }
    }

}