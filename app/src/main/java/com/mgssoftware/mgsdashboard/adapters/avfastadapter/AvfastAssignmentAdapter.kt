package com.mgssoftware.mgsdashboard.adapters.avfastadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.avfastmodel.Log
import com.mgssoftware.mgsdashboard.databinding.AvfastAssignmentItemRecyclerBinding

class AvfastAssignmentAdapter(private val assignmentList: List<Log?>?) :
    RecyclerView.Adapter<AvfastAssignmentAdapter.AssignmentViewHolder>() {

    private lateinit var binding: AvfastAssignmentItemRecyclerBinding

    inner class AssignmentViewHolder(itemBinding: AvfastAssignmentItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Log?) {
            binding.imgAssignment.setImageResource(R.drawable.ic_notice_orange)
            binding.txtAssignmentInfo.text = data?.description ?: ""
            binding.txtDateOfAssignment.text = data?.createdAt ?: ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        binding =
            AvfastAssignmentItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.bind(assignmentList?.get(position))
        if (position == (assignmentList?.size ?: 0) - 1) {
            binding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = assignmentList?.size!!
}