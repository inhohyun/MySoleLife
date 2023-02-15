package com.shoppi.shoppi.mysolelife.contentsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.shoppi.mysolelife.R
import kotlinx.coroutines.channels.ReceiveChannel


class ContentRVAdapter(val items : ArrayList<String>) :RecyclerView.Adapter<ContentRVAdapter.Viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)

        return Viewholder(v)

    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {

        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
     return items.size
    }

    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String){

        }

    }
}