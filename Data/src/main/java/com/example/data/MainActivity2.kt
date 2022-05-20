package com.example.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    lateinit var dataAdapter: ModuleDataAdapter
    private var receivingArrayList = ArrayList<String>()

    var sendArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // send the data
        buttonModule.setOnClickListener {
            val name = etTextModule.text.toString()
            sendArrayList.add(name)
            val model = object : Model {
                override fun passName(): ArrayList<String> {
                    return sendArrayList
                }
            }
            ReturnName(model)
            Toast.makeText(this, "Data has send", Toast.LENGTH_SHORT).show()
        }

        // get the data
        val getNameList = GetName.modelInterface.passName()
        receivingArrayList.addAll(getNameList)
        setRecyclerView()

        previousActivity.setOnClickListener {
            val intent = Intent()
            setResult(0, intent)
            finish()
        }
    }

    private fun setRecyclerView() {
        dataAdapter = ModuleDataAdapter()
        dataAdapter.setName2(receivingArrayList)
        recyclerView.adapter = dataAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}