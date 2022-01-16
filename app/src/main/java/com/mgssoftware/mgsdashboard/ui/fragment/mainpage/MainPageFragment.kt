package com.mgssoftware.mgsdashboard.ui.fragment.mainpage

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentMainPageBinding

class MainPageFragment : BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardMobileApplication.setOnClickListener {
            val action = MainPageFragmentDirections.actionMainPageFragmentToMainFragment()
            findNavController().navigate(action)
        }
        binding.cardRedminer.setOnClickListener {
            val action = MainPageFragmentDirections.actionMainPageFragmentToRedminerMainFragment()
            findNavController().navigate(action)
        }
    }
}