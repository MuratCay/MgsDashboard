package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.AvfastAssignmentItemRecyclerBinding
import com.mgssoftware.mgsdashboard.model.AvfastAssignment

class AvfastAssignmentAdapter(private val assignmentList: ArrayList<AvfastAssignment>) :
    RecyclerView.Adapter<AvfastAssignmentAdapter.AssignmentViewHolder>() {

    private lateinit var binding: AvfastAssignmentItemRecyclerBinding

    inner class AssignmentViewHolder(itemBinding: AvfastAssignmentItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: AvfastAssignment) {
            binding.imgAssignment.setImageResource(R.drawable.ic_notice_orange)
            binding.txtAssignmentInfo.text = data.assignmentDescription
            binding.txtDateOfAssignment.text = data.dateOfAssignment
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
        holder.bind(assignmentList[position])
        if (position == assignmentList.size - 1) {
            binding.line.visibility = View.GONE
        }else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = assignmentList.size


}