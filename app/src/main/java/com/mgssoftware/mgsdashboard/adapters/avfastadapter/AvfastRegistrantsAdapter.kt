package com.mgssoftware.mgsdashboard.adapters.avfastadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.avfastmodel.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.AvfastItemRegistrantsRecyclerBinding

class AvfastRegistrantsAdapter(private val registrantsList: List<RegisterUser?>?) :
    RecyclerView.Adapter<AvfastRegistrantsAdapter.RegistrantsViewHolder>() {

    private lateinit var binding: AvfastItemRegistrantsRecyclerBinding

    inner class RegistrantsViewHolder(itemBinding: AvfastItemRegistrantsRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: RegisterUser?) {
            binding.imgRegistrants.setImageResource(R.drawable.ic_person_orange)
            binding.txtRegistrantsName.text = data?.name ?: ""
            binding.txtRegistrantsSurname.text = data?.surname ?: ""
            binding.txtDateOfRegistrants.text = data?.createdAt ?: ""
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
        holder.bind(registrantsList?.get(position))

        if (position == (registrantsList?.size ?: 0) - 1) {
            binding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount() = registrantsList!!.size
}