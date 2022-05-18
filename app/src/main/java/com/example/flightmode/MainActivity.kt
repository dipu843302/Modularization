package com.example.flightmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.MainActivity2
import com.example.data.Model
import com.example.flightmode.adapter.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Model {

    var arrayList=ArrayList<String>()
    var dataList=ArrayList<String>()
 private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var data:String=etText.text.toString()
            dataList.add(data)
            passData(dataList)
        }
        setRecyclerView()
    }

    override fun passData(list:ArrayList<String>) {
        val intent=Intent(this,MainActivity2::class.java)
        val bundle=Bundle()
        bundle.putStringArrayList("name",list)
        intent.putExtra("bundle",bundle)
        startActivityForResult(intent,0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==0){
          val name= data?.getStringExtra("address")
            if (name != null) {
                arrayList.add(name)
            }else{
                Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun setRecyclerView(){
        dataAdapter=DataAdapter(arrayList)
       dataAdapter.setName(arrayList)
        recyclerView.adapter=dataAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}