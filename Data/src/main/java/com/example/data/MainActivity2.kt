package com.example.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    lateinit var dataAdapter: ModuleDataAdapter
    private var arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val name = intent.getBundleExtra("bundle")
        if (name != null) {
            arrayList.addAll(name.getStringArrayList("name")!!)
        }
        setRecyclerView()

        buttonModule.setOnClickListener {
            val data=etTextModule.text.toString()
            sendData(data)
        }
    }

    private fun sendData(address:String){
        val intent=Intent()
        intent.putExtra("address",address)
        setResult(0, intent)
        finish()
    }

   private fun setRecyclerView() {
        dataAdapter = ModuleDataAdapter()
        dataAdapter.setName2(arrayList)
        recyclerView.adapter = dataAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}