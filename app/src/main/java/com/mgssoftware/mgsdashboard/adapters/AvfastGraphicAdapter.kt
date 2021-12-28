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
import com.mgssoftware.mgsdashboard.databinding.ItemViewPagerGraphicBinding

class AvfastGraphicAdapter(
    val graphicsTitle: List<String>,
    val graphicsDescription: List<String>,
    val barBottomValue: List<String>
   // val barEntry: List<Float>
    ) : RecyclerView.Adapter<AvfastGraphicAdapter.AvfastViewHolder>() {

    private lateinit var binding: ItemViewPagerGraphicBinding

    inner class AvfastViewHolder(val itemBinding: ItemViewPagerGraphicBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvfastViewHolder {
        binding =
            ItemViewPagerGraphicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvfastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AvfastViewHolder, position: Int) {
        val currentGraphicsTitle = graphicsTitle[position]
        val currentGraphicsDescription = graphicsDescription[position]
        holder.itemBinding.graphicTitleText.text = currentGraphicsTitle
        holder.itemBinding.graphicDescription.text = currentGraphicsDescription

        val context = holder.itemView.context


        val barEntry = arrayListOf<BarEntry>()

        barEntry.add(BarEntry(1f,100f))
        barEntry.add(BarEntry(2f,100f))
        barEntry.add(BarEntry(3f,200f))
        barEntry.add(BarEntry(4f,300f))
        barEntry.add(BarEntry(5f,300f))

        val barDataSet = BarDataSet(barEntry,"")
        barDataSet.valueTextSize = 15f
        barDataSet.color = ContextCompat.getColor(
            context,
            R.color.graphic_orange
        )

        val barData = BarData(barDataSet)
        binding.barChart.apply {
            animateY(1500)
            setFitBars(true)
            description.textSize = 15f
            description.text = "Person"
            data = barData
            legend.formSize = 10f
            legend.textSize = 16f
            xAxis.valueFormatter = IndexAxisValueFormatter(barBottomValue)
            xAxis.textColor = ContextCompat.getColor(context,R.color.white)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = false
            axisLeft.isEnabled = true
            axisRight.isEnabled = false
            axisLeft.setDrawGridLines(false)
        }
    }
    override fun getItemCount() = graphicsTitle.size
}