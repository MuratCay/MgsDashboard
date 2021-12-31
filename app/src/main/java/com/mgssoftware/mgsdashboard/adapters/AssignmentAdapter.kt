package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.AssignmentItemRecyclerBinding
import com.mgssoftware.mgsdashboard.model.Assignment

class AssignmentAdapter(private val assignmentList: ArrayList<Assignment>) :
    RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    private lateinit var binding: AssignmentItemRecyclerBinding

    inner class AssignmentViewHolder(val itemBinding: AssignmentItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Assignment){
            binding.imgAssignment.setImageResource(R.drawable.ic_notice_orange)
            binding.txtAssignmentInfo.text = data.assignmentDescription
            binding.txtDateOfAssignment.text = data.dateOfAssignment
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        binding =
            AssignmentItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.bind(assignmentList[position])

    }

    override fun getItemCount() = assignmentList.size


}