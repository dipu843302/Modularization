package com.example.flightmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.GetName
import com.example.data.MainActivity2
import com.example.data.Model
import com.example.data.ReturnName
import com.example.flightmode.adapter.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Model {

    var receiveList = ArrayList<String>()
    var sendList = ArrayList<String>()
    private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // send the data
        button.setOnClickListener {
            GetName(this)
            Toast.makeText(this, "Data has send", Toast.LENGTH_SHORT).show()
        }
        nextActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, 0)
        }

        setRecyclerView()
    }

    override fun passName(): ArrayList<String> {
        val name = etText.text.toString()
        sendList.add(name)
        return sendList
    }

    private fun setRecyclerView() {
        dataAdapter = DataAdapter()
        dataAdapter.setName(receiveList)
        recyclerView.adapter = dataAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        val data = ReturnName.modelInterface?.passName()
        if (data != null) {
            receiveList.addAll(data)
        }
    }
}