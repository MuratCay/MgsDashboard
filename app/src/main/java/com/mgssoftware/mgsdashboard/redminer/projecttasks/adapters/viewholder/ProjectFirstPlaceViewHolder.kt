package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemProjectFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectFirstPlace

class ProjectFirstPlaceViewHolder(val itemBinding: ItemProjectFirstPlaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: ProjectFirstPlace) {
        itemBinding.imgPointStar.setImageResource(item.imgPointStar)
        itemBinding.txtName.text = item.txtName
        itemBinding.txtNumber.text = item.txtNumber
        itemBinding.txtStoryPoint.text = item.txtStoryPoint
    }
}