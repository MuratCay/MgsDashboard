package com.mgssoftware.mgsdashboard.avfast.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.avfast.data.model.Log
import com.mgssoftware.mgsdashboard.databinding.AvfastAssignmentItemRecyclerBinding

class AvfastAssignmentViewHolder(val itemBinding: AvfastAssignmentItemRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(data: Log?) {
        itemBinding.imgAssignment.setImageResource(R.drawable.ic_notice_orange)
        itemBinding.txtAssignmentInfo.text = data?.description ?: ""
        itemBinding.txtDateOfAssignment.text = data?.createdAt ?: ""
    }
}