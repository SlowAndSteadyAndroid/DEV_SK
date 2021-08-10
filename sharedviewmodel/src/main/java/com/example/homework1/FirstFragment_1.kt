package com.example.homework1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homework1.R

class FirstFragment_1 : Fragment(R.layout.fragment_first_1) {

    private val activityViewModel: FragmentViewModel by lazy {
        ViewModelProvider(this@FirstFragment_1, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return FragmentViewModel() as T
            }
        }).get(FragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btn_count_up).setOnClickListner {
            FragmentViewModel.addTwo()
        }
        fragmentViewModel.updateNum.observe(this@FirstFragment1) { result ->
            findViewById<TextView>(R.id.tv_count).text =result.toString()
        }
    }
}