package com.mgssoftware.mgsdashboard.reminder.openedtasks.adapters.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCreated

class OpenedTasksViewHolder(val itemBinding: ItemOpenedTasksRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: TaskCreated?) {
            itemBinding.txtNameAndSurname.text = item?.name ?: ""
            itemBinding.txtNumber.text = "${adapterPosition + 4}."
            itemBinding.txtValue.text = item?.points.toString()
    }
}