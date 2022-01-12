package com.mgssoftware.mgsdashboard.ui.fragment.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mgssoftware.mgsdashboard.ui.fragment.avfast.AvfastFragment
import com.mgssoftware.mgsdashboard.ui.fragment.petner.PetnerFragment
import com.mgssoftware.mgsdashboard.utils.Constants.NUM_TABS

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AvfastFragment()
            1 -> PetnerFragment()
            else -> AvfastFragment()
        }
    }
}
