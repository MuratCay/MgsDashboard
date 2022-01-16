package com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedFirstPlace

class OpenedTasksFirstPlaceViewHolder(val itemBinding: ItemOpenedTasksFirstPlaceBinding): RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: OpenedFirstPlace){
        itemBinding.imgFirstPlace.setImageResource(item.imgFirstPlace)
        itemBinding.txtName.text = item.txtName
        itemBinding.txtNumber.text = item.txtNumber
        itemBinding.txtStoryPoint.text = item.txtStoryPoint
        itemBinding.imgPointStar.setImageResource(item.imgPointStar)
    }
}