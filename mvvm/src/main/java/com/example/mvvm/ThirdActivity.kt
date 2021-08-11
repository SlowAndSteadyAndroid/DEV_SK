package com.example.mvvm

import android.os.Bundle
import com.example.mvvm.base.BaseActivity
import com.example.mvvm.databinding.ActivityThirdBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ThirdActivity : BaseActivity<ActivityThirdBinding>(R.layout.activity_third) {

    private val thirdViewModel by viewModel<ThirdViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}