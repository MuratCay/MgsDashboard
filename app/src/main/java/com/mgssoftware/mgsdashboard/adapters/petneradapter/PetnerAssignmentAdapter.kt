package com.mgssoftware.mgsdashboard.adapters.petneradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.PetnerAssignmentItemRecyclerBinding
import com.mgssoftware.mgsdashboard.model.PetnerAssignment

class PetnerAssignmentAdapter(private val assignmentList: ArrayList<PetnerAssignment>) :
    RecyclerView.Adapter<PetnerAssignmentAdapter.PetnerAssignmentViewHolder>() {

    private lateinit var binding: PetnerAssignmentItemRecyclerBinding

    inner class PetnerAssignmentViewHolder(itemBinding: PetnerAssignmentItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: PetnerAssignment) {
            binding.imgPetner.setImageResource(R.drawable.ic_notice_purple)
            binding.txtPetnerInfo.text = data.assignmentDescription
            binding.txtDateOfPetner.text = data.dateOfAssignment
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