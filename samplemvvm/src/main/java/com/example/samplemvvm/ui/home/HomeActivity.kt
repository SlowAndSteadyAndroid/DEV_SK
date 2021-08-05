package com.example.samplemvvm.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.samplemvvm.R
import com.example.samplemvvm.databinding.ActivityHomeBinding
import com.example.samplemvvm.ui.home.a.AFragment
import com.example.samplemvvm.ui.home.adapter.FragmentPagerAdapter
import com.example.samplemvvm.ui.home.b.BFragment
import com.example.samplemvvm.ui.home.c.CFragment
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel by viewModel<HomeViewModel>()

    private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lifecycle.addObserver(homeViewModel)
        initViewPager()


    }

    @SuppressLint("WrongConstant")
    private fun initViewPager() {

        with(binding) {
            val fragmentList = listOf(
                AFragment.newInstance(),
                BFragment.newInstance(),
                CFragment.newInstance()
            )

            homePager.apply {
                adapter = FragmentPagerAdapter(fragmentList, this@HomeActivity)
                offscreenPageLimit = LIMIT_COUNT
                isUserInputEnabled = false
            }

            TabLayoutMediator(bottomTab, homePager, tabConfigurationStrategy).attach()

        }
    }

    private val tabConfigurationStrategy =
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = resources.getStringArray(R.array.array_tab_name)[position]
        }


    companion object {

        private const val LIMIT_COUNT = 3

        fun getIntent(context: Context) =
            Intent(context, HomeActivity::class.java)
    }

}