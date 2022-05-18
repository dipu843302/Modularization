package com.example.flightmode

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallBack(
    var oldList:ArrayList<String>,
    var newList:ArrayList<String>,
):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
      return oldList.size
    }

    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}