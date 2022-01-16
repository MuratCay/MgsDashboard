package com.mgssoftware.mgsdashboard.avfast.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.avfast.adapters.viewholder.AvfastRegistrantsViewHolder
import com.mgssoftware.mgsdashboard.avfast.data.model.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.AvfastItemRegistrantsRecyclerBinding

class AvfastRegistrantsAdapter(private val registrantsList: List<RegisterUser?>?) :
    RecyclerView.Adapter<AvfastRegistrantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvfastRegistrantsViewHolder {
        val view =
            AvfastItemRegistrantsRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AvfastRegistrantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvfastRegistrantsViewHolder, position: Int) {
        holder.bind(registrantsList?.get(position))
        if (position == (registrantsList?.size ?: 0) - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList!!.size
}