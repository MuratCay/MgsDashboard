package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.adapters.AvfastAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.PetnerAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.PetnerGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.PetnerRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentPetnerBinding
import com.mgssoftware.mgsdashboard.model.AvfastAssignment
import com.mgssoftware.mgsdashboard.model.PetnerAssignment
import com.mgssoftware.mgsdashboard.model.PetnerRegistrants

class PetnerFragment : BaseFragment<FragmentPetnerBinding>(FragmentPetnerBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
    }

    private fun configureAssignmentRecyclerView() {
        val assignmentList = arrayListOf<PetnerAssignment>()
        val assignment1 =
            PetnerAssignment(
                R.drawable.ic_notice_purple,
                "Bursa ilinde yeni bir görev",
                "2 gün önce"
            )
        assignmentList.add(assignment1)

        repeat(9) {
            val assignment2 =
                PetnerAssignment(R.drawable.ic_notice_orange, "Bir kullanıcı giriş yaptı.", "3 gün önce")
            assignmentList.add(assignment2)
        }
        binding.rvAssignment.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = PetnerAssignmentAdapter(assignmentList)
        binding.rvAssignment.adapter = adapter
    }

    private fun configureRegistrantsRecyclerView() {
        val registrantsList = arrayListOf<PetnerRegistrants>()
        repeat(10) {
            val registrants =
                PetnerRegistrants(
                    R.drawable.ic_person_purple,
                    "E*** A*** kayıt oldu.",
                    "2 gün önce"
                )
            registrantsList.add(registrants)
        }
        binding.rvRegistrants.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = PetnerRegistrantsAdapter(registrantsList)
        binding.rvRegistrants.adapter = adapter
    }

    private fun configureGraphicRecyclerView() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni POST(FORUM)",
            "CHAT SAYISI", "POST YORUM(FORUM)",
        )
        val descriptionList = listOf("10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf("0", "1", "2", "3", "4", "5")
        val adapter = PetnerGraphicAdapter(list, descriptionList, barBottomValue)

        binding.rvGraphicPetner.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicPetner.adapter = adapter
    }

    private fun addIndicator() {
        binding.arIndicator.attachTo(binding.rvGraphicPetner, true)
    }
}