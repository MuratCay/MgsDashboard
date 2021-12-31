package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.adapters.AssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.RegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import com.mgssoftware.mgsdashboard.model.Assignment
import com.mgssoftware.mgsdashboard.model.Registrants


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val barEntryList = listOf<Pair<Float,Float>>()
        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
    }

    private fun configureAssignmentRecyclerView() {
        val assignmentList = arrayListOf<Assignment>()
        val assignment1 =
            Assignment(R.drawable.ic_notice_orange, "Bursa ilinde yeni bir görev", "2 gün önce")
        assignmentList.add(assignment1)

        repeat(9) {
            val assignment2 =
                Assignment(R.drawable.ic_notice_orange, "E*** A*** kayıt oldu.", "3 gün önce")
            assignmentList.add(assignment2)
        }
        binding.rvAssignment?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = AssignmentAdapter(assignmentList)
        binding.rvAssignment?.adapter = adapter
    }

    private fun configureRegistrantsRecyclerView() {
        val registrantsList = arrayListOf<Registrants>()
        repeat(10) {
            val registrants =
                Registrants(R.drawable.ic_person_orange, "E*** A*** kayıt oldu.", "2 gün önce")
            registrantsList.add(registrants)
        }
        binding.rvRegistrants?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = RegistrantsAdapter(registrantsList)
        binding.rvRegistrants?.adapter = adapter
    }

    private fun configureGraphicRecyclerView() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )
        val descriptionList = listOf("10", "10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf("0", "1", "2", "3", "4", "5")
        val adapter = AvfastGraphicAdapter(list, descriptionList, barBottomValue)

        binding.rvGraphic.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphic.adapter = adapter
    }

    private fun addIndicator() {
        binding.arIndicator?.attachTo(binding.rvGraphic, true)
    }

}

