package com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompletionFirsplaceBinding
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.CompletionFirstPlace

class TaskCompFirstPlaceViewHolder(val itemBinding: ItemTaskCompletionFirsplaceBinding): RecyclerView.ViewHolder(itemBinding.root) {
fun bind(item: CompletionFirstPlace){
    itemBinding.imgFirstPlace.setImageResource(item.imgFirstPlace)
    itemBinding.imgPointStar.setImageResource(item.imgPointStar)
    itemBinding.txtStoryPoint.text = item.txtStoryPoint
    itemBinding.txtName.text = item.txtName
    itemBinding.txtNumber.text = item.txtNumber
}
}