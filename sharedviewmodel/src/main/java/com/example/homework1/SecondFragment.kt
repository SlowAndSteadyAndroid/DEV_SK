package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class SecondFragment : Fragment(R.layout.fragment_second_main) {

    private val secondViewModel by viewModels<SecondViewModel>()

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondViewModel.sendValue.observe(viewLifecycleOwner) {
            mainViewModel.sendValue(it)
        }
    }
}