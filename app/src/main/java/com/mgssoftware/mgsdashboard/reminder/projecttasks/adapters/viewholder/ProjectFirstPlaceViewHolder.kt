package com.mgssoftware.mgsdashboard.reminder.projecttasks.adapters.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemProjectFirstPlaceBinding
import com.mgssoftware.mgsdashboard.reminder.data.model.TaskCompletedTeam

class ProjectFirstPlaceViewHolder(val itemBinding: ItemProjectFirstPlaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: TaskCompletedTeam?) {
        if (item != null) {
            itemBinding.txtName.text = item.name
            itemBinding.txtStoryPoint.text = item.points.toString()
            itemBinding.txtNumber.text = "${adapterPosition + 1}."
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