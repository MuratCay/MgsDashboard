package com.mgssoftware.mgsdashboard.ui.fragment.mainpage

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentMainPageBinding
import java.text.SimpleDateFormat
import java.util.*


class MainPageFragment : BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCardRedminer()
        buttonCardMobileApplication()
        clock()
    }

    private fun buttonCardRedminer() {
        binding.cardRedminer.setOnClickListener {
            val action2 = MainPageFragmentDirections.actionMainPageFragmentToRedminerMainFragment()
            findNavController().navigate(action2)
        }
    }

    private fun buttonCardMobileApplication() {
        binding.cardMobileApplication.setOnClickListener {
            val action = MainPageFragmentDirections.actionMainPageFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }

    private fun clock() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy, HH:mm", Locale.ENGLISH)
        val formattedDate = dateFormat.format(calendar.time)
        binding.txtDate.text = formattedDate.toString()
    }
}