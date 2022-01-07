package com.mgssoftware.mgsdashboard.adapters.petneradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.petnermodel.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.PetnerItemRegistrantsRecyclerBinding

class PetnerRegistrantsAdapter(private val registrantsList: List<RegisterUser>) :
    RecyclerView.Adapter<PetnerRegistrantsAdapter.PetnerRegistrantsViewHolder>() {

    private lateinit var binding: PetnerItemRegistrantsRecyclerBinding

    inner class PetnerRegistrantsViewHolder(itemBinding: PetnerItemRegistrantsRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: RegisterUser) {
            binding.imgRegistrants.setImageResource(R.drawable.ic_person_purple)
            binding.txtDateOfRegistrants.text = data.createdAt
            binding.txtRegistrantsName.text = data.name
            binding.txtRegistrantsSurName.text = data.surname
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
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList.size
}