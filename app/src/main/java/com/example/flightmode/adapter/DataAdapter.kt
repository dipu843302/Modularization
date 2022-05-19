package com.example.flightmode.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.ModuleDiffUtilCallBack
import com.example.flightmode.R
import kotlinx.android.synthetic.main.item_layout.view.*

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private var arrayList = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = arrayList[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setName(newNameList: ArrayList<String>) {
        val diffUtil = ModuleDiffUtilCallBack(arrayList, newNameList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        arrayList = newNameList
        diffResult.dispatchUpdatesTo(this)
    }

    class DataViewHolder(var item: View) : RecyclerView.ViewHolder(item) {
        fun setData(data: String) {
            item.apply {
                tvName.text = data
            }
        }
    }
}