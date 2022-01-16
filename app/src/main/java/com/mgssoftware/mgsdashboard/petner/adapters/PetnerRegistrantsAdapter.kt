package com.mgssoftware.mgsdashboard.petner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.petner.adapters.viewholder.PetnerRegistrantsViewHolder
import com.mgssoftware.mgsdashboard.petner.data.model.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.PetnerItemRegistrantsRecyclerBinding

class PetnerRegistrantsAdapter(private val registrantsList: List<RegisterUser?>?) :
    RecyclerView.Adapter<PetnerRegistrantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerRegistrantsViewHolder {
        val view =
            PetnerItemRegistrantsRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PetnerRegistrantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetnerRegistrantsViewHolder, position: Int) {
        holder.bind(registrantsList?.get(position))
        if (position == (registrantsList?.size ?: 0) - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList!!.size
}