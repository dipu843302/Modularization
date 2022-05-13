package com.example.flightmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.data.MainActivity2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneModeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val name = etText.text.toString()
            intent.putExtra("name", name)
            startActivityForResult(intent, 1)
        }
        val intent = intent
        tvData.text = intent.getStringExtra("address")

//        receiver= AirplaneModeChangeReceiver()
//        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
//            registerReceiver(receiver,it)
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val address = data?.getStringExtra("address")
                tvData.text = address
            }
        }

    }

//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(receiver)
//    }
}