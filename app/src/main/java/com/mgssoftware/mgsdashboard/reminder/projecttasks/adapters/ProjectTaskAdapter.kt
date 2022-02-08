package com.mgssoftware.mgsdashboard.reminder.projecttasks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompletedTeam
import com.mgssoftware.mgsdashboard.reminder.projecttasks.adapters.viewholder.ProjectTasksViewHolder

class ProjectTaskAdapter(private val projectList: List<TaskCompletedTeam?>?) :
    RecyclerView.Adapter<ProjectTasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectTasksViewHolder {
        val view = ItemProjectTasksRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProjectTasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectTasksViewHolder, position: Int) {
        holder.bind(projectList?.get(position))
        holder.itemBinding.line.visibility = if (position == (projectList?.size ?: 0) - 1) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = projectList!!.size
}