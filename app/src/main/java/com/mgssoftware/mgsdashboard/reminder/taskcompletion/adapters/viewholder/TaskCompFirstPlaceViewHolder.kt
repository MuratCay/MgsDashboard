package com.mgssoftware.mgsdashboard.reminder.taskcompletion.adapters.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemTaskCompletionFirsplaceBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompleted

class TaskCompFirstPlaceViewHolder(val itemBinding: ItemTaskCompletionFirsplaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: TaskCompleted?) {
        if (item != null) {
            itemBinding.txtNumber.text = "${adapterPosition + 1}."
            itemBinding.txtStoryPoint.text = item.points.toString()
            itemBinding.txtName.text = item.name
            Glide.with(itemView.context).load(item.imageUrl).into(itemBinding.imgFirstPlace)
        } else {
            throw IllegalArgumentException("Invalid data")
        }

        when (adapterPosition) {
            0 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star)
            1 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star_gray)
            2 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star_brown)
        }
    }
}


