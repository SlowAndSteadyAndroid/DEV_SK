package com.example.homework1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class BFirstFragment : Fragment(R.layout.fragment_first_b) {

    private val fragmentViewModel by viewModels<FirstViewModel> (ownerProducer = {requireParentFragment()})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_count_up).setOnClickListener {
            Toast.makeText(requireContext(), "Click B", Toast.LENGTH_SHORT).show()
        }
    }
}

