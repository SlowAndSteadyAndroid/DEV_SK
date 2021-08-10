package com.example.homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels


class FirstFragment : Fragment(R.layout.fragment_first_main) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    private val mainFragmentViewModel by viewModels<FirstFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
