package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemProjectFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompletedTeam

class ProjectFirstPlaceViewHolder(val itemBinding: ItemProjectFirstPlaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompletedTeam) {
        itemBinding.txtName.text = item.name
        itemBinding.txtStoryPoint.text = item.points.toString()
        itemBinding.txtNumber.text = "${adapterPosition + 1}."

        when (adapterPosition) {
            0 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star)
            1 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_gray)
            2 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_brown)
        }
    }
}