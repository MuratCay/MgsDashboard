package com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompleted

class TaskCompletionViewHolder(val itemBinding: ItemTaskCompRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompleted) {
        itemBinding.txtValue.text = item.points.toString()
        itemBinding.txtNameAndSurname.text = item.name
        itemBinding.txtNumber.text = "${adapterPosition + 4}."
    }
}