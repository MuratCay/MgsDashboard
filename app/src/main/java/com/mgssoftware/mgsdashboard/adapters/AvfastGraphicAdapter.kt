package com.mgssoftware.mgsdashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemAvfastGraphicBinding

class AvfastGraphicAdapter(
    private val graphicsTitle: List<String>,
    private val graphicsDescription: List<String>,
    private val barBottomValue: List<String>
//    val barEntryList: List<Pair<Float,Float>>
) : RecyclerView.Adapter<AvfastGraphicAdapter.AvfastViewHolder>() {

    private lateinit var binding: ItemAvfastGraphicBinding

    inner class AvfastViewHolder(val itemBinding: ItemAvfastGraphicBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvfastViewHolder {
        binding =
            ItemAvfastGraphicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvfastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AvfastViewHolder, position: Int) {
        val currentGraphicsTitle = graphicsTitle[position]
        val currentGraphicsDescription = graphicsDescription[position]
        holder.itemBinding.graphicTitleText.text = currentGraphicsTitle
        holder.itemBinding.graphicDescription.text = currentGraphicsDescription
        val context = holder.itemView.context

        val barEntry = arrayListOf<BarEntry>()

        barEntry.add(BarEntry(1f, 100f))
        barEntry.add(BarEntry(2f, 200f))
        barEntry.add(BarEntry(3f, 300f))
        barEntry.add(BarEntry(4f, 400f))
        barEntry.add(BarEntry(5f, 500f))

        val barDataSet = BarDataSet(barEntry, "")
        barDataSet.color = ContextCompat.getColor(
            context,
            R.color.graphic_orange
        )

        val barData = BarData(barDataSet)
        barData.setDrawValues(false)
        barData.barWidth = 0.75f
        binding.barChart.apply {
            animateY(1750)
            setFitBars(true)
            data = barData
            description.isEnabled = false
            legend.formSize = 0f
            legend.textSize = 16f
            xAxis.valueFormatter = IndexAxisValueFormatter(barBottomValue)
            xAxis.textColor = ContextCompat.getColor(context, R.color.white)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 14f
            xAxis.axisLineWidth = 1f
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.white)
            xAxis.gridColor = ContextCompat.getColor(context, R.color.graphic_background_color)
            axisRight.isEnabled = false
            axisLeft.textColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.white)
            axisLeft.axisLineWidth = 1f
            axisLeft.isEnabled = true
            axisLeft.textSize = 14f
            axisLeft.setDrawGridLines(false)
            invalidate()
        }
    }

    override fun getItemCount() = graphicsTitle.size
}