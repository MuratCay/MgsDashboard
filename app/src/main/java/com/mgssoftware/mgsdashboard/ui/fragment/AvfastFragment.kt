package com.mgssoftware.mgsdashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.adapters.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import com.mgssoftware.mgsdashboard.databinding.ItemViewPagerGraphicBinding


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

    private val itemBinding: ItemViewPagerGraphicBinding by lazy {
        ItemViewPagerGraphicBinding.inflate(
            layoutInflater
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf<String>(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )
        val descriptionList = listOf<String>("10", "10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf<String>("0","1","2","3","4","5")
        val barEntry = listOf<Float>()

        val adapter = AvfastGraphicAdapter(list, descriptionList,barBottomValue)
        binding.rvGraphic.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphic.adapter = adapter
    }

}