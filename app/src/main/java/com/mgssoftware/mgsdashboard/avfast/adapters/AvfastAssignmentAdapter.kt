package com.mgssoftware.mgsdashboard.avfast.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.avfast.adapters.viewholder.AvfastAssignmentViewHolder
import com.mgssoftware.mgsdashboard.avfast.data.model.Log
import com.mgssoftware.mgsdashboard.databinding.AvfastAssignmentItemRecyclerBinding

class AvfastAssignmentAdapter(private val assignmentList: List<Log?>?) :
    RecyclerView.Adapter<AvfastAssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvfastAssignmentViewHolder {
        val view =
            AvfastAssignmentItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AvfastAssignmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvfastAssignmentViewHolder, position: Int) {
        holder.bind(assignmentList?.get(position))
        if (position == (assignmentList?.size ?: 0) - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = assignmentList?.size!!
}