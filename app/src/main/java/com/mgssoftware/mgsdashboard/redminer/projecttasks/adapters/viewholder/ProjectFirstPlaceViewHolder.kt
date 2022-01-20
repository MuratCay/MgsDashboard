package com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemProjectFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompletedTeam

class ProjectFirstPlaceViewHolder(val itemBinding: ItemProjectFirstPlaceBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCompletedTeam?) {
        if (item != null){
            itemBinding.txtName.text = item.name
            itemBinding.txtStoryPoint.text = item.points.toString()
            itemBinding.txtNumber.text = "${adapterPosition + 1}."
        } else {
            Log.e("Null", "API dan null geldi!")
        }

        when (adapterPosition) {
            0 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star)
            1 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star_gray)
            2 -> itemBinding.imgPointStar.setImageResource(R.drawable.ic_point_star_brown)
        }
    }
}