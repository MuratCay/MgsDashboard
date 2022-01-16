package com.mgssoftware.mgsdashboard.avfast.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.avfast.data.model.RegisterUser
import com.mgssoftware.mgsdashboard.databinding.AvfastItemRegistrantsRecyclerBinding

class AvfastRegistrantsViewHolder(val itemBinding: AvfastItemRegistrantsRecyclerBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(data: RegisterUser?) {
        itemBinding.imgRegistrants.setImageResource(R.drawable.ic_person_orange)
        itemBinding.txtRegistrantsName.text = data?.name ?: ""
        itemBinding.txtRegistrantsSurname.text = data?.surname ?: ""
        itemBinding.txtDateOfRegistrants.text = data?.createdAt ?: ""
    }
}