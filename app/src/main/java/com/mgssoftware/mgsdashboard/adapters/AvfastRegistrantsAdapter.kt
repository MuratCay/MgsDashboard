package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.AvfastItemRegistrantsRecyclerBinding
import com.mgssoftware.mgsdashboard.model.AvfastRegistrants

class AvfastRegistrantsAdapter(private val registrantsList: ArrayList<AvfastRegistrants>) :
    RecyclerView.Adapter<AvfastRegistrantsAdapter.RegistrantsViewHolder>() {

    private lateinit var binding: AvfastItemRegistrantsRecyclerBinding

    inner class RegistrantsViewHolder(itemBinding: AvfastItemRegistrantsRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: AvfastRegistrants) {
            binding.imgRegistrants.setImageResource(R.drawable.ic_person_orange)
            binding.txtRegistrantsInfo.text = data.personDescription
            binding.txtDateOfRegistrants.text = data.dateOfRegistration

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistrantsViewHolder {
        binding =
            AvfastItemRegistrantsRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RegistrantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegistrantsViewHolder, position: Int) {
        holder.bind(registrantsList[position])

        if (position == registrantsList.size - 1) {
            binding.line.visibility = View.GONE
        }else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList.size
}