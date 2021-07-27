package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
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

        mainViewModel.mainViewStateLiveData.observe(this) {
            when (it) {

                MainViewModel.MainViewState.StartOperation -> {
                    binding.progressbar.isVisible = true
                }

                MainViewModel.MainViewState.EndOperation -> {
                    binding.progressbar.isVisible = false
                }

                MainViewModel.MainViewState.OperationPlus -> {
                    binding.tvResult.text =
                        (binding.etInputA.text.toString().toInt() + binding.etInputB.text.toString()
                            .toInt()).toString()
                }
            }

        }

    }
}