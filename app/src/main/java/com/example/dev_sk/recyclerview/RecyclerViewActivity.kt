package com.example.dev_sk.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dev_sk.R

class RecyclerViewActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }

    private val recyclerViewAdapter = RecyclerViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter.addAll(PERSON_LIST)

    }

    companion object{
        private val PERSON_LIST = mutableListOf<Pair<String,Int>>().apply {
            for(i in 0..10){
                add(Pair(i.toString(), i))
            }
        }
    }
}