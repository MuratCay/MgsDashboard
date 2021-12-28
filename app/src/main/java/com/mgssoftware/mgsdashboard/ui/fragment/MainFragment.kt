package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.adapters.FragmentAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureTabLayout()
    }

    private fun configureTabLayout() {

        val title = arrayListOf("AvFast", "Petner")

        binding.viewPager.adapter = FragmentAdapter(childFragmentManager, lifecycle)
        binding.viewPager.isUserInputEnabled = false

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = title[position]
        }.attach()

        val root: View = binding.tabLayout.getChildAt(0)
        (root as LinearLayout).showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.tab_divider)
        drawable.also { root.dividerDrawable = it }


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                binding.tabLayout.tabTextColors = ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.tab_layout_item_selected_avfast
                )
                binding.tabLayout.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.application_purple
                    )
                )

                if (tab?.position == 0) {
                    binding.tabLayout.setSelectedTabIndicatorColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.graphic_orange
                        )
                    )
                    binding.tabLayout.tabTextColors = ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.tab_layout_item_selected_petner
                    )

                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}


