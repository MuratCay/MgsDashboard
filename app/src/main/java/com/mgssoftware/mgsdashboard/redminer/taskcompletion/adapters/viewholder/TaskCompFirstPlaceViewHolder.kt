package com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompletionFirsplaceBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompleted

class TaskCompFirstPlaceViewHolder(val itemBinding: ItemTaskCompletionFirsplaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompleted) {
        itemBinding.txtNumber.text = "${adapterPosition + 1}."
        itemBinding.txtStoryPoint.text = item.points.toString()
        itemBinding.txtName.text = item.name
        Glide.with(itemView.context).load(item.imageUrl).into(itemBinding.imgFirstPlace)

        when (adapterPosition) {
            0 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star)
            1 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_gray)
            2 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_brown)
        }
    }
}


