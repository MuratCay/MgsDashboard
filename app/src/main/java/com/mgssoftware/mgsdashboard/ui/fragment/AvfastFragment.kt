package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.adapters.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )
        val descriptionList = listOf("10", "10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf("0", "1", "2", "3", "4", "5")
//        val barEntryList = listOf<Pair<Float,Float>>()

        val adapter = AvfastGraphicAdapter(list, descriptionList, barBottomValue)
        binding.rvGraphic.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphic.adapter = adapter
        binding.arIndicator?.attachTo(binding.rvGraphic, true)
    }
}

