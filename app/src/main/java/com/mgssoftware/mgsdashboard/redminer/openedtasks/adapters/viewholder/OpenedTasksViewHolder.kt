package com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCreated

class OpenedTasksViewHolder(val itemBinding: ItemOpenedTasksRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCreated?) {
            itemBinding.txtNameAndSurname.text = item?.name ?: ""
            itemBinding.txtNumber.text = "${adapterPosition + 4}."
            itemBinding.txtValue.text = item?.points.toString()
    }
}