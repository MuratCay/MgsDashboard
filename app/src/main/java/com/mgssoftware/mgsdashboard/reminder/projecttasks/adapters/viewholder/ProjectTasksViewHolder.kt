package com.mgssoftware.mgsdashboard.reminder.projecttasks.adapters.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompletedTeam

class ProjectTasksViewHolder(val itemBinding: ItemProjectTasksRecyclerBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: TaskCompletedTeam?){
        if (item != null){
            itemBinding.txtNameAndSurname.text = item.name
            itemBinding.txtNumber.text = "${adapterPosition + 4}."
            itemBinding.txtValue.text = item.points.toString()
        }
    }
}