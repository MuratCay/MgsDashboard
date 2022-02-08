package com.mgssoftware.mgsdashboard.ui.fragment.remindermain

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentReminderMainBinding

class ReminderMainFragment :
    BaseFragment<FragmentReminderMainBinding>(FragmentReminderMainBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ReminderMainFragmentAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.intoTabLayout, binding.viewPager) { _, _ ->
        }.attach()
    }
}