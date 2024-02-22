package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeItemViewBinding
import com.example.myapplication.model.Post

class HomeRecyclerViewAdapter(val listItem : MutableList<Post>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    var onClick : ((Post) -> Unit)? = null

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
            Glide.with(holder.itemView.context).load(item.userAvatar).into(homeItemViewUserAvatar)
            homeItemViewUserID.text = item.userID
            homeItemViewUserPostLocation.text = item.location
            Glide.with(holder.itemView.context).load(item.postPhoto).into(homeItemViewUserPost)
        }

        holder.itemView.setOnClickListener {
            onClick?.invoke(Post(listItem[position].userAvatar, listItem[position].userID, listItem[position].location, listItem[position].postPhoto))
        }
    }


    override fun getItemCount() = listItem.size
}