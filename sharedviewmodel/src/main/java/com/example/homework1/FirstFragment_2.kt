package com.example.homework1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FirstFragment_2 : Fragment(R.layout.fragment_first_2) {

    private val fragmentViewModel: FragmentViewModel by lazy {
        ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return FragmentViewModel() as T
            }
        }).get(FragmentViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<Button>(R.id.btn_count_up).setOnClickListener {
            FragmentViewModel.addTwo()
        }

    }
}

