package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.adapters.AvfastAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.AvfastRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import com.mgssoftware.mgsdashboard.model.AvfastAssignment
import com.mgssoftware.mgsdashboard.model.AvfastRegistrants


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
    }

    private fun configureAssignmentRecyclerView() {
        val assignmentList = arrayListOf<AvfastAssignment>()
        val assignment1 =
            AvfastAssignment(
                R.drawable.ic_notice_orange,
                "Bursa ilinde yeni bir görev",
                "2 gün önce"
            )
        assignmentList.add(assignment1)

        repeat(9) {
            val assignment2 =
                AvfastAssignment(R.drawable.ic_notice_orange, "E*** A*** kayıt oldu.", "3 gün önce")
            assignmentList.add(assignment2)
        }
        binding.rvAssignment?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = AvfastAssignmentAdapter(assignmentList)
        binding.rvAssignment?.adapter = adapter
    }

    private fun configureRegistrantsRecyclerView() {
        val registrantsList = arrayListOf<AvfastRegistrants>()
        repeat(10) {
            val registrants =
                AvfastRegistrants(
                    R.drawable.ic_person_orange,
                    "E*** A*** kayıt oldu.",
                    "2 gün önce"
                )
            registrantsList.add(registrants)
        }
        binding.rvRegistrants?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = AvfastRegistrantsAdapter(registrantsList)
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

        binding.rvGraphicAvfast.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicAvfast.adapter = adapter
    }

    private fun addIndicator() {
        binding.arIndicator?.attachTo(binding.rvGraphicAvfast, true)
    }

}

