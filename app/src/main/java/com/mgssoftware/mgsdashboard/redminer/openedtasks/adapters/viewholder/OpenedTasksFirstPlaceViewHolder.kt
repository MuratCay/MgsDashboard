package com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksFirstPlaceBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCreated

class OpenedTasksFirstPlaceViewHolder(val itemBinding: ItemOpenedTasksFirstPlaceBinding): RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: TaskCreated?){
        if (item != null){
            itemBinding.txtName.text = item.name
            itemBinding.txtStoryPoint.text = item.points.toString()
            Glide.with(itemView.context).load(item.imageUrl).into(itemBinding.imgFirstPlace)
            itemBinding.txtNumber.text = "${adapterPosition + 1}."
        } else {
            Log.e("Null", "API dan null geldi!")
        }

        when (adapterPosition) {
            0 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star)
            1 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_gray)
            2 -> itemBinding.imgPointStar.setImageResource(R.drawable.img_point_star_brown)
        }
    }
}