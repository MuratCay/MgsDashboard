package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.PetnerItemRegistrantsRecyclerBinding
import com.mgssoftware.mgsdashboard.model.PetnerRegistrants

class PetnerRegistrantsAdapter(private val registrantsList: ArrayList<PetnerRegistrants>) :
    RecyclerView.Adapter<PetnerRegistrantsAdapter.PetnerRegistrantsViewHolder>() {

    private lateinit var binding: PetnerItemRegistrantsRecyclerBinding

    inner class PetnerRegistrantsViewHolder(itemBinding: PetnerItemRegistrantsRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: PetnerRegistrants) {
            binding.imgRegistrants.setImageResource(R.drawable.ic_person_purple)
            binding.txtRegistrantsInfo.text = data.personDescription
            binding.txtDateOfRegistrants.text = data.dateOfRegistration
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerRegistrantsViewHolder {
        binding =
            PetnerItemRegistrantsRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PetnerRegistrantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetnerRegistrantsViewHolder, position: Int) {
        holder.bind(registrantsList[position])
        if (position == registrantsList.size - 1) {
            binding.line.visibility = View.GONE
        }else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList.size
}