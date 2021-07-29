package com.example.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.mvvm.base.BaseActivity
import com.example.mvvm.data.repo.MainRepositoryImpl
import com.example.mvvm.data.source.local.LocalDataSourceImpl
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel =
        MainViewModel(MainRepositoryImpl.getInstance(LocalDataSourceImpl.getInstance()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = mainViewModel
        setContentView(binding.root)

        mainViewModel.mainViewStateLiveData.observe(this) { viewState ->
            when (viewState) {

                MainViewModel.MainViewState.StartOperation -> {
                    binding.progressbar.isVisible = true
                }

                MainViewModel.MainViewState.EndOperation -> {
                    binding.progressbar.isVisible = false
                }

                is MainViewModel.MainViewState.Operation -> {
                    binding.tvResult.text = viewState.resultOperation
                }
                MainViewModel.MainViewState.RouteSub -> {
                    startActivity(Intent(this@MainActivity, SubActivity::class.java))
                }

                is MainViewModel.MainViewState.GetLocalData -> {
                    binding.tvMain.text = viewState.data
                }
            }

        }
    }
}