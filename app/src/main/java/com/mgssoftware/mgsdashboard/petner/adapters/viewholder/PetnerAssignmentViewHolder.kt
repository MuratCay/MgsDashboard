package com.mgssoftware.mgsdashboard.petner.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.petner.data.model.Log
import com.mgssoftware.mgsdashboard.databinding.PetnerAssignmentItemRecyclerBinding

class PetnerAssignmentViewHolder(val itemBinding: PetnerAssignmentItemRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(data: Log?) {
        itemBinding.imgPetner.setImageResource(R.drawable.ic_notice_purple)
        itemBinding.txtPetnerInfo.text = data?.description ?: ""
        itemBinding.txtDateOfPetner.text = data?.createdAt ?: ""
    }
}