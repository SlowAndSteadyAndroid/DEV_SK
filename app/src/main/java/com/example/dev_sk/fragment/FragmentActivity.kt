package com.example.dev_sk.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dev_sk.R

class FragmentActivity : AppCompatActivity(R.layout.activity_fragment_exam) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, AMainFragment())
        }.commit()

    }
}