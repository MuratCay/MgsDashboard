package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompletedTeam
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCreated

class ProjectTasksViewHolder(val itemBinding: ItemProjectTasksRecyclerBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompletedTeam){
        itemBinding.txtNameAndSurname.text = item.name
        itemBinding.txtNumber.text = "${adapterPosition + 4}."
        itemBinding.txtValue.text = item.points.toString()

    }
}