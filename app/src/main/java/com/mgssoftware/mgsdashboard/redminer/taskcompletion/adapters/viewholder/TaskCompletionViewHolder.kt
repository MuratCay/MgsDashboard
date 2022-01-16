package com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.TaskCompletionDataClass

class TaskCompletionViewHolder(val itemBinding: ItemTaskCompRecyclerBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompletionDataClass){
        itemBinding.txtNumber.text = item.txtNumber
        itemBinding.txtValue.text = item.txtValue
        itemBinding.txtNameAndSurname.text = item.nameAndSurname
    }
}