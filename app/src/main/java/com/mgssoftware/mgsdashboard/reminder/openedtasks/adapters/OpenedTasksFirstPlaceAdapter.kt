package com.mgssoftware.mgsdashboard.reminder.openedtasks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksFirstPlaceBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCreated
import com.mgssoftware.mgsdashboard.reminder.openedtasks.adapters.viewholder.OpenedTasksFirstPlaceViewHolder

class OpenedTasksFirstPlaceAdapter(private val openedOpenedFirstPlace: List<TaskCreated?>?) :
    RecyclerView.Adapter<OpenedTasksFirstPlaceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OpenedTasksFirstPlaceViewHolder {
        val view = ItemOpenedTasksFirstPlaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OpenedTasksFirstPlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: OpenedTasksFirstPlaceViewHolder, position: Int) {
        holder.bind(openedOpenedFirstPlace?.get(position))
        if (position == itemCount-1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = 3
}