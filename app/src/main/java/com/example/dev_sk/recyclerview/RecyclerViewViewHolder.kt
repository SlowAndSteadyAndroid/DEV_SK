package com.example.dev_sk.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dev_sk.R

class RecyclerViewViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
    ) {


    private val name = itemView.findViewById<TextView>(R.id.name_tv)
    private val age = itemView.findViewById<TextView>(R.id.age_tv)

    fun bind(data : Pair<String,Int>) {
        name.text = data.first
        age.text = data.second.toString()
    }
}