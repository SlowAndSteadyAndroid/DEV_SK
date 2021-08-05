package com.example.samplemvvm.ui.home.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvm.R
import com.example.samplemvvm.data.model.Person
import com.example.samplemvvm.databinding.ItemPersonBinding

class PersonViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
) {

    private val binding = ItemPersonBinding.bind(itemView)

    fun bind(item: Person) {
        with(binding){
            tvName.text = item.name
            tvAge.text = item.age.toString()
            tvGender.text = item.gender
            tvJob.text = item.job
        }
    }
}