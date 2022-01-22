package com.mgssoftware.mgsdashboard.avfast.adapters.viewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.avfast.data.model.*
import com.mgssoftware.mgsdashboard.databinding.ItemAvfastGraphicBinding
import com.mgssoftware.mgsdashboard.utils.convertToDateString
import java.util.ArrayList


class AvfastGraphicViewHolder(private val itemBinding: ItemAvfastGraphicBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    /**
     * Tek bir fonksiyonda yazmak için ->
     *    fun tasksChart(tasksChart: List<Any?>?, weeklyTasksCount: Int?, type: String) {
    var list: ArrayList<WeeklyTasksChart> = ArrayList()
    when (type){
    "week" ->{
    tasksChart?.let{
    for (item in tasksChart)
    list.add(item as WeeklyTasksChart)
    }
    }
    "day" -> {
    tasksChart?.let{
    for (item in tasksChart)
    list.add(item as WeeklyTasksChart)
    }
    }
    }
    if (tasksChart != null) {
    val barEntry = arrayListOf<BarEntry>()
    val barBottomValue = arrayListOf<String>()
    for (i in list.indices) {
    barEntry.add(
    BarEntry(i.toFloat(), list[i]?.createdAt!!.toFloat())
    )
    barBottomValue.add(convertToDateString(list.toString()))
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
     */

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
                barBottomValue.add(convertToDateString(usersMonthlyTotalUsersChart[i]?.createdAt.toString()))
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
                barBottomValue.add(convertToDateString(dailyUsersChart[i]?.createdAt.toString()))
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
                barBottomValue.add(convertToDateString(weeklyTasksChart[i]?.createdAt.toString()))
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
                barBottomValue.add(convertToDateString(weeklyAppliedTasksChart[i]?.createdAt.toString()))
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
                barBottomValue.add(convertToDateString(weeklyEvaluatedTasksChart[i]?.createdAt.toString()))
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
                barBottomValue.add(convertToDateString(weeklyDoneTasksChart[i]?.createdAt.toString()))
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
            xAxis.granularity = 1f

            axisRight.isEnabled = true
            axisRight.textSize = 0f
            axisRight.textColor = ContextCompat.getColor(context,R.color.graphic_background_color)

            axisLeft.textColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineWidth = 1f
            axisLeft.isEnabled = true
            axisLeft.textSize = 14f
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