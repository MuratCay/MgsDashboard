package com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedTasksDataClass

class OpenedTasksViewHolder(val itemBinding: ItemOpenedTasksRecyclerBinding): RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: OpenedTasksDataClass){
        itemBinding.txtNumber.text = item.txtNumber
        itemBinding.txtValue.text = item.txtValue
        itemBinding.txtNameAndSurname.text = item.nameAndSurname
    }
}