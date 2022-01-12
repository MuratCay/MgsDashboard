package com.mgssoftware.mgsdashboard.adapters.petneradapter.petnerviewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.data.petnermodel.CommentsInLastFiveMonthsChart
import com.mgssoftware.mgsdashboard.data.petnermodel.ConversationsInLastFiveWeeksChart
import com.mgssoftware.mgsdashboard.data.petnermodel.PostsInLastFiveMonthsChart
import com.mgssoftware.mgsdashboard.data.petnermodel.UsersInLastFiveMonthsChart
import com.mgssoftware.mgsdashboard.databinding.ItemPetnerGraphicBinding


class PetnerGraphicViewHolder(private val itemBinding: ItemPetnerGraphicBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun usersInLastFiveMonthsChart(
        usersInLastFiveMonthsChart: List<UsersInLastFiveMonthsChart?>?,
        usersInLastMonthCount: Int?
    ) {
        if (usersInLastFiveMonthsChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in usersInLastFiveMonthsChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), usersInLastFiveMonthsChart[i]?.count!!.toFloat())
                )
                barBottomValue.add(usersInLastFiveMonthsChart[i]?.month.toString())
            }
            itemBinding.graphicDescription.text = usersInLastMonthCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.application_purple
            )

            val barData = BarData(barDataSet)
            barData.setDrawValues(false)
            barData.barWidth = 0.75f
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun usersLoggedInLastWeekChart(
        usersLoggedLnLastWeekChart: List<Any>?,
        usersLoggedLnTodayCount: Int?
    ) {
        if (usersLoggedLnLastWeekChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in usersLoggedLnLastWeekChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), 0f)
                    // Any dönüyor data data dolarsa yaz
                )
                barBottomValue.add("0")
                // Any dönüyor data data dolarsa yaz
            }
            itemBinding.graphicDescription.text = usersLoggedLnTodayCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.application_purple
            )

            val barData = BarData(barDataSet)
            barData.setDrawValues(false)
            barData.barWidth = 0.75f
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun postsInLastFiveMonthsChart(
        postsInLastFiveMonthsChart: List<PostsInLastFiveMonthsChart?>?,
        postsInLastMonthCount: Int?
    ) {
        if (postsInLastFiveMonthsChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in postsInLastFiveMonthsChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), postsInLastFiveMonthsChart[i]?.count!!.toFloat())
                )
                barBottomValue.add(postsInLastFiveMonthsChart[i]?.month.toString())
            }
            itemBinding.graphicDescription.text = postsInLastMonthCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.application_purple
            )

            val barData = BarData(barDataSet)
            barData.setDrawValues(false)
            barData.barWidth = 0.75f
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun conversationsInLastFiveWeeksChart(
        conversationsInLastFiveWeeksChart: List<ConversationsInLastFiveWeeksChart?>?,
        conversationsInLastWeekCount: Int?
    ) {
        if (conversationsInLastFiveWeeksChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in conversationsInLastFiveWeeksChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), conversationsInLastFiveWeeksChart[i]?.count!!.toFloat())
                )
                barBottomValue.add(conversationsInLastFiveWeeksChart[i]?.month.toString())
            }
            itemBinding.graphicDescription.text = conversationsInLastWeekCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.application_purple
            )

            val barData = BarData(barDataSet)
            barData.setDrawValues(false)
            barData.barWidth = 0.75f
            setAllBarChart(barData, barBottomValue)
        }
    }

    fun commentsInLastFiveMonthsChart(
        commentsInLastFiveMonthsChart: List<CommentsInLastFiveMonthsChart?>?,
        commentsInLastMonthCount: Int?
    ) {
        if (commentsInLastFiveMonthsChart != null) {
            val barEntry = arrayListOf<BarEntry>()
            val barBottomValue = arrayListOf<String>()
            for (i in commentsInLastFiveMonthsChart.indices) {
                barEntry.add(
                    BarEntry(i.toFloat(), commentsInLastFiveMonthsChart[i]?.count!!.toFloat())
                )
                barBottomValue.add(commentsInLastFiveMonthsChart[i]?.month.toString())
            }
            itemBinding.graphicDescription.text = commentsInLastMonthCount.toString()

            val barDataSet = BarDataSet(barEntry, "")
            barDataSet.color = ContextCompat.getColor(
                itemBinding.root.context,
                R.color.application_purple
            )

            val barData = BarData(barDataSet)
            barData.setDrawValues(false)
            barData.barWidth = 0.75f
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
            xAxis.textColor = ContextCompat.getColor(context, R.color.black)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 12f
            xAxis.axisLineWidth = 1f
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.black)
            xAxis.gridColor = ContextCompat.getColor(context, R.color.white)
            xAxis.isGranularityEnabled = true
            xAxis.labelRotationAngle = 90f
            xAxis.granularity = 1f

            axisRight.isEnabled = false

            axisLeft.textColor = ContextCompat.getColor(context, R.color.black)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.black)
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

    fun setPetnerGraphTitle(graphicTitle: String) {
        itemBinding.graphicTitleText.text = graphicTitle
    }
}