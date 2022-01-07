package com.mgssoftware.mgsdashboard.adapters.petneradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.petnermodel.Log
import com.mgssoftware.mgsdashboard.databinding.PetnerAssignmentItemRecyclerBinding

class PetnerAssignmentAdapter(private val assignmentList: List<Log>) :
    RecyclerView.Adapter<PetnerAssignmentAdapter.PetnerAssignmentViewHolder>() {

    private lateinit var binding: PetnerAssignmentItemRecyclerBinding

    inner class PetnerAssignmentViewHolder(itemBinding: PetnerAssignmentItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Log) {
            binding.imgPetner.setImageResource(R.drawable.ic_notice_purple)
            binding.txtPetnerInfo.text = data.description
            binding.txtDateOfPetner.text = data.createdAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerAssignmentViewHolder {
        binding =
            PetnerAssignmentItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PetnerAssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetnerAssignmentViewHolder, position: Int) {
        holder.bind(assignmentList[position])
        if (position == assignmentList.size - 1) {
            binding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = assignmentList.size
}