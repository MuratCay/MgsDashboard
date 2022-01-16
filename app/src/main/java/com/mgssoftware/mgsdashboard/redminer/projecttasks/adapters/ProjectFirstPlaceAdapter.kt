package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder.ProjectFirstPlaceViewHolder

class ProjectFirstPlaceAdapter(private val projectList: MutableList<ProjectFirstPlace>) :
    RecyclerView.Adapter<ProjectFirstPlaceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectFirstPlaceViewHolder {
        val view =
            ItemProjectFirstPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectFirstPlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectFirstPlaceViewHolder, position: Int) {
        holder.bind(projectList[position])
        if (position == projectList.size - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = projectList.size
}