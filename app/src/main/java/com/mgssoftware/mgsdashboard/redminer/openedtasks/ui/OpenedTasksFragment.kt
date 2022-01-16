package com.mgssoftware.mgsdashboard.redminer.openedtasks.ui

import android.os.Bundle
import android.view.View
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentOpenedTasksBinding
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedFirstPlace
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedTasksAdapter
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedTasksFirstPlaceAdapter
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.OpenedTasksDataClass

class OpenedTasksFragment : BaseFragment<FragmentOpenedTasksBinding>(FragmentOpenedTasksBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFirstPlaceTask.adapter = OpenedTasksFirstPlaceAdapter(loadFirstPlace())
        binding.rvTaskRecycler.adapter = OpenedTasksAdapter(loadTaskRecycler())
    }

    private fun loadTaskRecycler(): MutableList<OpenedTasksDataClass> {
        return mutableListOf(
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00"),
            OpenedTasksDataClass("7.","Murat Çay","00")
        )
    }

    private fun loadFirstPlace(): MutableList<OpenedFirstPlace> {
        return mutableListOf(
            OpenedFirstPlace(
                "1.",
                R.drawable.img_elif_akdogan,
                "Elif Akdoğan",
                R.drawable.img_point_star,
                "90"
            ),
            OpenedFirstPlace(
                "2.",
                R.drawable.img_arda_aydin,
                "Arda Aydın",
                R.drawable.img_point_star_gray,
                "85"
            ),
            OpenedFirstPlace(
                "3.",
                R.drawable.img_aykut_karagulle,
                "Aykut Karagülle",
                R.drawable.img_point_star_brown,
                "70"
            )

        )
    }
}