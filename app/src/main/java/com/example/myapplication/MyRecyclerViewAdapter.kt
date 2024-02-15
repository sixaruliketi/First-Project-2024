package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemViewBinding

class MyRecyclerViewAdapter(val listItem : MutableList<Post>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    var onClick : ((Post) -> Unit)? = null

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemViewBinding.bind(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItem[position]
        holder.binding.apply {
            titleTextView.text = item.title
            detailsTextView.text = item.details
        }

        holder.itemView.setOnClickListener {
            onClick?.invoke(Post(listItem[position].title, listItem[position].details))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = listItem.size

}