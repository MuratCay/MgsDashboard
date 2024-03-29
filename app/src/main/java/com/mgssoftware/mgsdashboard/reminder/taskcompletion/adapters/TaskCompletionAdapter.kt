package com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompRecyclerBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompleted
import com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters.viewholder.TaskCompletionViewHolder


class TaskCompletionAdapter(private val taskCompList: List<TaskCompleted?>?) :
    RecyclerView.Adapter<TaskCompletionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskCompletionViewHolder {
        val view =
            ItemTaskCompRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TaskCompletionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskCompletionViewHolder, position: Int) {
        holder.bind(taskCompList?.get(position))
        holder.itemBinding.line.visibility = if (position == (taskCompList?.size ?: 0) - 1) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = taskCompList!!.size
}