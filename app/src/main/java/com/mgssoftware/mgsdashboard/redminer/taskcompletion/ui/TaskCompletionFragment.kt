package com.mgssoftware.mgsdashboard.redminer.taskcompletion.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentTaskCompletionBinding
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.CompletionFirstPlace
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.TaskCompFirstPlaceAdapter
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.TaskCompletionAdapter
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.TaskCompletionDataClass


class TaskCompletionFragment : BaseFragment<FragmentTaskCompletionBinding>(
    FragmentTaskCompletionBinding::inflate
) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureBarChart()

        binding.rvFirstPlaceTask.adapter = TaskCompFirstPlaceAdapter(loadFirstPlace())
        binding.rvTaskRecycler.adapter = TaskCompletionAdapter(loadTaskRecycler())
    }

    private fun loadFirstPlace(): MutableList<CompletionFirstPlace> {
        return mutableListOf(
            CompletionFirstPlace(
                "1.",
                R.drawable.img_elif_akdogan,
                "Elif Akdoğan",
                R.drawable.img_point_star,
                "90"
            ),
            CompletionFirstPlace(
                "2.",
                R.drawable.img_arda_aydin,
                "Arda Aydın",
                R.drawable.img_point_star_gray,
                "85"
            ),
            CompletionFirstPlace(
                "3.",
                R.drawable.img_aykut_karagulle,
                "Aykut Karagülle",
                R.drawable.img_point_star_brown,
                "70"
            )
        )
    }

    private fun loadTaskRecycler(): MutableList<TaskCompletionDataClass> {
        return mutableListOf(
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00"),
            TaskCompletionDataClass("7.", "Murat Çay", "00")
        )
    }

    private fun model(): Array<String> {
        return arrayOf(
            "İsim", "İsim", "İsim", "İsim",
            "İsim", "İsim", "İsim",
            "İsim", "İsim", "İsim",
        )
    }

    private fun configureBarChart() {
        val barEntry = arrayListOf<BarEntry>()

        barEntry.add(BarEntry(0f, 90f))
        barEntry.add(BarEntry(1f, 85f))
        barEntry.add(BarEntry(2f, 70f))
        barEntry.add(BarEntry(3f, 60f))
        barEntry.add(BarEntry(4f, 55f))
        barEntry.add(BarEntry(5f, 45f))
        barEntry.add(BarEntry(6f, 40f))
        barEntry.add(BarEntry(7f, 35f))
        barEntry.add(BarEntry(8f, 30f))
        barEntry.add(BarEntry(9f, 25f))


        val barDataSet = BarDataSet(barEntry, "Storypoint")
        barDataSet.color = R.color.main_page_blue_light
        barDataSet.valueTextSize = 10f
        barDataSet.valueFormatter
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.main_page_blue_light)
        val barData = BarData(barDataSet)

        binding.barChart.apply {
            animateY(1500, Easing.EaseOutBounce)
            data = barData
            setFitBars(false)
            description.isEnabled = false

            data.barWidth = 0.7f
            data.setDrawValues(true)
            setTouchEnabled(false)


            axisLeft.textColor = ContextCompat.getColor(context, R.color.redmine_graphic_text_color)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.main_page_blue_light)
            axisLeft.axisLineWidth = 1f
            axisLeft.isEnabled = true
            axisLeft.textSize = 12f
            axisLeft.setDrawGridLines(false)
            axisLeft.minWidth = 0f
            axisLeft.axisMinimum = 0f
            axisLeft.axisMaximum = 100f
            axisLeft.granularity = 1.0f
            axisLeft.isGranularityEnabled = true

            xAxis.textColor = ContextCompat.getColor(context, R.color.redmine_graphic_text_color)
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.main_page_blue_light)
            xAxis.valueFormatter = IndexAxisValueFormatter(model())
            xAxis.gridColor = ContextCompat.getColor(context, R.color.white)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 8f
            xAxis.axisLineWidth = 1f
            xAxis.isGranularityEnabled = true
            xAxis.granularity = 1f
            xAxis.axisMinimum = 10f
            xAxis.mAxisMinimum = -0.8f

            axisRight.isEnabled = false

            setExtraOffsets(5f, 0f, 5f, 10f)

            legend.form = Legend.LegendForm.SQUARE
            legend.textSize = 14f
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER

            invalidate()
        }

    }
}
