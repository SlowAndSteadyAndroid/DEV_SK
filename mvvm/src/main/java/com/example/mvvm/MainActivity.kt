package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        setContentView(binding.root)


        with(mainViewModel) {

            inputA.observe(this@MainActivity) {
                Log.d("결과", "InputA : $it")
            }

            inputB.observe(this@MainActivity) {
                Log.d("결과", "InputB : $it")
            }

        }

        with(binding) {
            buttonResult.setOnClickListener {
                tvResult.text =
                    (etInputA.text.toString().toInt() + etInputB.text.toString().toInt()).toString()
            }
        }
    }
}