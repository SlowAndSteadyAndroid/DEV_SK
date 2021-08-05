package com.example.samplemvvm.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samplemvvm.databinding.ActivitySplashBinding
import com.example.samplemvvm.ui.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    private val splashViewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycle.addObserver(splashViewModel)

        initViewModel()

    }

    private fun initViewModel() {
        splashViewModel.viewStateLiveData.observe(this) { viewState ->
            when (viewState) {
                SplashViewModel.SplashViewState.RouteMain -> {
                    routeMain()
                }

                SplashViewModel.SplashViewState.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun routeMain() {
        startActivity(
            HomeActivity.getIntent(this@SplashActivity).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        )
    }

}