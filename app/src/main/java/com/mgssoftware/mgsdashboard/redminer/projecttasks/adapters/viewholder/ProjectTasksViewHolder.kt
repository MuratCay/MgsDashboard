package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectTasksDataClass

class ProjectTasksViewHolder(val itemBinding: ItemProjectTasksRecyclerBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: ProjectTasksDataClass){
        itemBinding.txtNameAndSurname.text = item.nameAndSurname
        itemBinding.txtNumber.text = item.number
        itemBinding.txtValue.text = item.value
    }
}