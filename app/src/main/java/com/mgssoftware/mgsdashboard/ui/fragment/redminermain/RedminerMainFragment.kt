package com.mgssoftware.mgsdashboard.ui.fragment.redminermain

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentRedminerMainBinding

class RedminerMainFragment :
    BaseFragment<FragmentRedminerMainBinding>(FragmentRedminerMainBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = RedminerMainFragmentAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.intoTabLayout, binding.viewPager) { tab, position ->

        }.attach()


    }
}