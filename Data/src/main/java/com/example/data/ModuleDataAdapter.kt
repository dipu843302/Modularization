package com.example.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ModuleDataAdapter : RecyclerView.Adapter<ModuleDataAdapter.ModuleDataViewHolder>() {
    private var arrayList = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ModuleDataViewHolder(view)
    }

    override fun onBindViewHolder(holderModule: ModuleDataViewHolder, position: Int) {
        val data = arrayList[position]
        holderModule.setData(data)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setName2(newNameList: ArrayList<String>) {
        val diffUtil = ModuleDiffUtilCallBack(arrayList, newNameList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        arrayList = newNameList
        diffResult.dispatchUpdatesTo(this)
    }

    class ModuleDataViewHolder(var item: View) : RecyclerView.ViewHolder(item) {
        fun setData(data: String) {
            item.apply {
                tvName.text = data
            }
        }
    }
}