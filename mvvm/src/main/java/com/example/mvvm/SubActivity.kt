package com.example.mvvm

import android.os.Bundle
import com.example.mvvm.base.BaseActivity
import com.example.mvvm.data.repo.MainRepositoryImpl
import com.example.mvvm.data.source.local.LocalDataSourceImpl
import com.example.mvvm.databinding.ActivitySubBinding

class SubActivity : BaseActivity<ActivitySubBinding>(R.layout.activity_sub) {

    private val subViewModel =
        SubViewModel(MainRepositoryImpl.getInstance(LocalDataSourceImpl.getInstance()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvSub.text = subViewModel.getLocalData()

    }
}