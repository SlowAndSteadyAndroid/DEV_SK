package com.example.dev_sk.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dev_sk.R

//제가 A- > B 가는 방법에 대해서 보여드릴게요 (0)
// 선규님이 B -> A 보내는방법.  ()
class FragmentActivity : AppCompatActivity(R.layout.activity_fragment_exam), DataSendListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun sendData(data: String) {

        supportFragmentManager.fragments.forEach { fragment->
            if(fragment is BMainFragment){
                fragment.getData(data)
            }
        }
    }
}