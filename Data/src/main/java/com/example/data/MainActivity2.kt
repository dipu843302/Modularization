package com.example.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2(var model: Model) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        tvDataModule.text = intent.getStringExtra("name")

        buttonModule.setOnClickListener {
            val address = etTextModule.text.toString()
            model.passData(address)
            finish()
        }
    }

    fun getModelInstance(model: Model) {

    }

}