package com.example.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        tvDataModule.setText(intent.getStringExtra("name"))

        buttonModule.setOnClickListener{
            val intent2=Intent()
            var address=etTextModule.text.toString()
            intent2.putExtra("address",address)
            setResult(RESULT_OK,intent2)
            finish()
        }
    }
}