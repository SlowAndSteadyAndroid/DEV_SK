package com.example.dev_sk.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewViewHolder>() {

    private val personList = mutableListOf<Pair<String, Int>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return RecyclerViewViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun addAll(list: List<Pair<String, Int>>) {
        personList.addAll(list)
        notifyDataSetChanged()
    }
}

