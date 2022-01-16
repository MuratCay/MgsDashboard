package com.mgssoftware.mgsdashboard.petner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.petner.adapters.viewholder.PetnerAssignmentViewHolder
import com.mgssoftware.mgsdashboard.petner.data.model.Log
import com.mgssoftware.mgsdashboard.databinding.PetnerAssignmentItemRecyclerBinding

class PetnerAssignmentAdapter(private val assignmentList: List<Log?>?) :
    RecyclerView.Adapter<PetnerAssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerAssignmentViewHolder {
        val view =
            PetnerAssignmentItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PetnerAssignmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetnerAssignmentViewHolder, position: Int) {
        holder.bind(assignmentList?.get(position))
        if (position == (assignmentList?.size ?: 0) - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = assignmentList!!.size
}