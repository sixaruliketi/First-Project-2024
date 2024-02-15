package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            myRecyclerViewAdapter = MyRecyclerViewAdapter(getData())
            myRecyclerView.adapter = myRecyclerViewAdapter
            myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyclerViewAdapter.onClick = {
                val intent = Intent(this@MainActivity, ItemZoomActivity::class.java)
                intent.putExtra("TITLE",it.title)
                intent.putExtra("DETAILS", it.details)
                startActivity(intent)
            }
        }
    }

    private fun getData(): MutableList<Post> {
        val listItem = ArrayList<Post>()
        listItem.add(Post("title 1","this is first post in my recycler view!!!"))
        listItem.add(Post("title 2","this is second post in my recycler view!!!"))
        listItem.add(Post("title 3","this is third post in my recycler view!!!"))
        listItem.add(Post("title 4","this is forth post in my recycler view!!!"))
        listItem.add(Post("title 5","this is fifth post in my recycler view!!!"))
        listItem.add(Post("title 6","this is sixth post in my recycler view!!!"))
        return listItem
    }

}