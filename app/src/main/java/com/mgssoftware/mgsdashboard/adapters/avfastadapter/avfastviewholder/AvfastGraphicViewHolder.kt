package com.mgssoftware.mgsdashboard.adapters.avfastadapter.avfastviewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.avfastmodel.*
import com.mgssoftware.mgsdashboard.databinding.ItemAvfastGraphicBinding


class AvfastGraphicViewHolder(private val itemBinding: ItemAvfastGraphicBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun usersInLastFiveMonths(
        usersMonthlyTotalUsersChart: List<MonthlyTotalUsersChart?>?,
        monthlyTotalUsersCount: Int?
    ) {
        if (usersMonthlyTotalUsersChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in usersMonthlyTotalUsersChart.indices) {
                barEntry.add(
                    BarEntry(
                        i.toFloat(),
                        usersMonthlyTotalUsersChart[i]?.usersCount!!.toFloat()
                    )
                )
                barBottomValue.add(usersMonthlyTotalUsersChart[i]?.month.toString())
            }
            itemBinding.graphicDescription.text = monthlyTotalUsersCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )

            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun dailyLoginUser(
        dailyUsersChart: List<DailyLoggedInUsersChart?>?,
        dailyLoggedInUsersCount: Int?
    ) {
        if (dailyUsersChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in dailyUsersChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), dailyUsersChart[i]?.usersCount!!.toFloat())
                )
                barBottomValue.add(dailyUsersChart[i]?.day.toString())
            }
            itemBinding.graphicDescription.text = dailyLoggedInUsersCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )
            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun weeklyTasksChart(weeklyTasksChart: List<WeeklyTasksChart?>?, weeklyTasksCount: Int?) {
        if (weeklyTasksChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in weeklyTasksChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), weeklyTasksChart[i]?.usersCount!!.toFloat())
                )
                barBottomValue.add(weeklyTasksChart[i]?.month.toString())
            }
            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )
            itemBinding.graphicDescription.text = weeklyTasksCount.toString()

            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun weeklyAppliedTasks(
        weeklyAppliedTasksChart: List<WeeklyAppliedTasksChart?>?,
        weeklyAppliedTasksCount: Int?
    ) {
        if (weeklyAppliedTasksChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in weeklyAppliedTasksChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), weeklyAppliedTasksChart[i]?.usersCount!!.toFloat())
                )
                barBottomValue.add(weeklyAppliedTasksChart[i]?.month.toString())
            }
            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )
            itemBinding.graphicDescription.text = weeklyAppliedTasksCount.toString()

            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun weeklyEvaluatedTasks(
        weeklyEvaluatedTasksChart: List<WeeklyEvaluatedTasksChart?>?,
        weeklyEvaluatedTasksCount: Int?
    ) {
        if (weeklyEvaluatedTasksChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in weeklyEvaluatedTasksChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), weeklyEvaluatedTasksChart[i]?.usersCount!!.toFloat())
                )
                barBottomValue.add(weeklyEvaluatedTasksChart[i]?.month.toString())
            }
            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )
            itemBinding.graphicDescription.text = weeklyEvaluatedTasksCount.toString()

            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun weeklyDoneTasks(
        weeklyDoneTasksChart: List<WeeklyDoneTasksChart?>?,
        weeklyAppliedTasksCount: Int?
    ) {
        if (weeklyDoneTasksChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in weeklyDoneTasksChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), weeklyDoneTasksChart[i]?.usersCount!!.toFloat())
                )
                barBottomValue.add(weeklyDoneTasksChart[i]?.month.toString())
            }
            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.graphic_orange
            )
            itemBinding.graphicDescription.text = weeklyAppliedTasksCount.toString()

            val barData = BarData(barDataSet)
            setAllBarChart(barData, barBottomValue)
        }
    }

    private fun setAllBarChart(barEntryDataGet: BarData, barBottomValue: List<String>) {

        itemBinding.barChart.apply {
            animateY(1500)
            setFitBars(true)
            data = barData
            description.isEnabled = false
            legend.formSize = 0f
            legend.textSize = 16f

            xAxis.valueFormatter = IndexAxisValueFormatter(barBottomValue)
            xAxis.textColor = ContextCompat.getColor(context, R.color.white)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 12f
            xAxis.axisLineWidth = 1f
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.white)
            xAxis.gridColor = ContextCompat.getColor(context, R.color.graphic_background_color)
            xAxis.isGranularityEnabled = true
            xAxis.labelRotationAngle = 90f
            xAxis.granularity = 1f

            axisRight.isEnabled = false

            axisLeft.textColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineWidth = 1f
            axisLeft.isEnabled = true
            axisLeft.textSize = 12f
            axisLeft.setDrawGridLines(false)
            axisLeft.minWidth = 10f
            axisLeft.axisMinimum = 0f
            axisLeft.granularity = 1.0f
            axisLeft.isGranularityEnabled = true

            setTouchEnabled(false)
            isDragEnabled = true

            data = barEntryDataGet
            data.barWidth = 0.7f
            data.setDrawValues(false)

            invalidate()
        }
    }

    fun setAvfastGraphTitle(graphicTitle: String) {
        itemBinding.graphicTitleText.text = graphicTitle
    }
}