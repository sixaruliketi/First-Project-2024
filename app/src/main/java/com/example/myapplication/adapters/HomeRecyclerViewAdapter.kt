package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeItemViewBinding
import com.example.myapplication.model.Post

class HomeRecyclerViewAdapter(val listItem : MutableList<Post>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = HomeItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item_view, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = listItem[position]
        holder.binding.apply {
            homeItemViewUserAvatar.setImageResource(item.userAvatar)
            homeItemViewUserID.text = item.userID
            homeItemViewUserPostLocation.text = item.location
            homeItemViewUserPost.setImageResource(item.postPhoto)
        }
    }


    override fun getItemCount() = listItem.size
}