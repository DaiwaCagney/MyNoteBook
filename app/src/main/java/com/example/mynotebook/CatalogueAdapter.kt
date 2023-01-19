package com.example.mynotebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotebook.model.Catalogue

class MyAdapter(private val context: Context, private val data: List<Catalogue>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.textId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.catalogue_list_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            val item = data[position]
            holder.textView.text = context.resources.getString(item.catalogueId)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}