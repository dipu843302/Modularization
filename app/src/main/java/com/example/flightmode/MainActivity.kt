package com.example.flightmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.MainActivity2
import com.example.data.Model
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Model {
    lateinit var mainActivity2: MainActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivity2= MainActivity2(this)

        button.setOnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
    override fun passData(name: String) {
        tvData.text=name
    }
}