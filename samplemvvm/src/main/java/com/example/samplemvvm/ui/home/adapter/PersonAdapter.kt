package com.example.samplemvvm.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvm.data.model.Person
import com.example.samplemvvm.ui.home.adapter.viewholder.PersonViewHolder

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {

    private val personList = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(parent)

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount(): Int =
        personList.size


    fun addAll(list: List<Person>) {
        personList.addAll(list)
        notifyDataSetChanged()
    }
}