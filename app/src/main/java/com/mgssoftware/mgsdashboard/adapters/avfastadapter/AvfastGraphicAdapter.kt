package com.mgssoftware.mgsdashboard.adapters.avfastadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemAvfastGraphicBinding

class AvfastGraphicAdapter(
    private val graphicsTitle: List<String>,
    private val graphicsDescription: List<String>,
    private val barBottomValue: List<String>,
    private val listBarData: ArrayList<BarData>
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

        binding.barChart.apply {
            animateY(1750)
            setFitBars(true)
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
            setTouchEnabled(false)
            data = listBarData[position]
            invalidate()
        }
//        val yAxis = binding.barChart.axisLeft
//        binding.barChart.axisRight.isEnabled = false
//        yAxis.enableGridDashedLine(10f, 10f, -10f)
//        yAxis.setAxisMaximum(200f)
//        yAxis.setAxisMinimum(-50f)
    }

    override fun getItemCount() = graphicsTitle.size
}