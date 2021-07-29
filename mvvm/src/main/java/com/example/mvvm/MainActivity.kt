package com.example.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.mvvm.base.BaseActivity
import com.example.mvvm.data.repo.MainRepositoryImpl
import com.example.mvvm.data.source.local.LocalDataSourceImpl
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    private val mainViewModel =
        MainViewModel(MainRepositoryImpl.getInstance(LocalDataSourceImpl.getInstance()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = mainViewModel

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