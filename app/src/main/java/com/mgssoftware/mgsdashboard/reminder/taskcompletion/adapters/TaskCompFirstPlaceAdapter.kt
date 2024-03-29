package com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompletionFirsplaceBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompleted
import com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters.viewholder.TaskCompFirstPlaceViewHolder

class TaskCompFirstPlaceAdapter(private val completionFirstPlaceList: List<TaskCompleted?>?) :
    RecyclerView.Adapter<TaskCompFirstPlaceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskCompFirstPlaceViewHolder {
        val view =
            ItemTaskCompletionFirsplaceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TaskCompFirstPlaceViewHolder(view)
    }

    override fun onBindViewHolder(holderFirstPlace: TaskCompFirstPlaceViewHolder, position: Int) {
        holderFirstPlace.bind(
            completionFirstPlaceList?.get(position)
        )

        if (position == itemCount - 1) {
            holderFirstPlace.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = 3
}