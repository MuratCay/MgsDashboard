package com.mgssoftware.mgsdashboard.petner.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.petner.data.model.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.PetnerItemRegistrantsRecyclerBinding

class PetnerRegistrantsViewHolder(val itemBinding: PetnerItemRegistrantsRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(data: RegisterUser?) {
        itemBinding.imgRegistrants.setImageResource(R.drawable.ic_person_purple)
        itemBinding.txtDateOfRegistrants.text = data?.createdAt ?: ""
        itemBinding.txtRegistrantsName.text = data?.name ?: ""
        itemBinding.txtRegistrantsSurName.text = data?.surname ?: ""
    }
}