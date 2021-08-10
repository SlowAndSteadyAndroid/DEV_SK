package com.example.homework1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ASecondFragment : Fragment(R.layout.fragment_second_a) {

    private val secondViewModel by viewModels<SecondViewModel>(ownerProducer = { requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_count_up).setOnClickListener {
            secondViewModel.sendValue("Click ASecondFragment")
        }
    }
}