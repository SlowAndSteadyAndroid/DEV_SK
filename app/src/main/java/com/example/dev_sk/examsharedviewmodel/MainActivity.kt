package com.example.dev_sk.examsharedviewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dev_sk.R

// sharedViewModel 을 이용하여 데이터 주고받는 것을 구현하기.
class MainActivity : AppCompatActivity(R.layout.activity_fragment_exam) {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this@MainActivity, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        findViewById<Button>(R.id.btn_count_up).setOnClickListener {
            mainViewModel.addTwo()
        }

        mainViewModel.updateNum.observe(this@MainActivity) { result ->
            findViewById<TextView>(R.id.tv_count).text = result.toString()
        }
    }
}