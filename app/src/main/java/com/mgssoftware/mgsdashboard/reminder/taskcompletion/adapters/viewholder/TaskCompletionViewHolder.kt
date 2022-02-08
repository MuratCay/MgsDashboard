package com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompRecyclerBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompleted

class TaskCompletionViewHolder(val itemBinding: ItemTaskCompRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: TaskCompleted?) {
        itemBinding.txtValue.text = item?.points.toString()
        itemBinding.txtNameAndSurname.text = item?.name ?: ""
        itemBinding.txtNumber.text = "${adapterPosition + 4}."
    }
}