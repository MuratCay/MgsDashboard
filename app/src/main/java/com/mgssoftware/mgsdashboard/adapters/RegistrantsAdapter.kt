package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemRegistrantsRecyclerBinding
import com.mgssoftware.mgsdashboard.model.Assignment
import com.mgssoftware.mgsdashboard.model.Registrants

class RegistrantsAdapter(private val registrantsList: ArrayList<Registrants>) :
    RecyclerView.Adapter<RegistrantsAdapter.RegistrantsViewHolder>() {

    private lateinit var binding: ItemRegistrantsRecyclerBinding

    inner class RegistrantsViewHolder(val itemBinding: ItemRegistrantsRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Registrants) {
            binding.imgRegistrants.setImageResource(R.drawable.ic_person_orange)
            binding.txtRegistrantsInfo.text = data.personDescription
            binding.txtDateOfRegistrants.text = data.dateOfRegistration

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistrantsViewHolder {
        binding =
            ItemRegistrantsRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RegistrantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegistrantsViewHolder, position: Int) {
        holder.bind(registrantsList[position])
    }

    override fun getItemCount() = registrantsList.size


}