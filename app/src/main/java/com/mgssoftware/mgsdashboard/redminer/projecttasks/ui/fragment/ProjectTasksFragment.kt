package com.mgssoftware.mgsdashboard.redminer.projecttasks.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.data.service.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentProjectTasksBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.RedminerAPI
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompletedTeam
import com.mgssoftware.mgsdashboard.redminer.data.remote.RedminerRetrofitClient
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectFirstPlaceAdapter
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectTaskAdapter
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.viewholder.ProjectTasksViewHolder
import com.mgssoftware.mgsdashboard.redminer.projecttasks.ui.viewmodel.ProjectTasksViewModel
import com.mgssoftware.mgsdashboard.ui.factory.ViewModelFactory
import retrofit2.Retrofit

class ProjectTasksFragment :
    BaseFragment<FragmentProjectTasksBinding>(FragmentProjectTasksBinding::inflate) {

    private val retrofit: Retrofit by lazy {
        RedminerRetrofitClient.getRedminerRetrofitClient()
    }
    private val apiService: RetrofitAPI by lazy {
        retrofit.create(RetrofitAPI::class.java)
    }
    private val repository: MainRepository by lazy {
        MainRepository(apiService)
    }
    private val viewModel: ProjectTasksViewModel by viewModels {
        ViewModelFactory(repository)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureBarChart()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.rvFirstPlace.observe(viewLifecycleOwner,::rvFirstPlaceObserver)
        viewModel.getRvFirstPlace()
        viewModel.rvProjectTasks.observe(viewLifecycleOwner,::rvProjectTasksObserver)
        viewModel.getRvProjectTasks()
    }

    private fun rvProjectTasksObserver(response: RedminerAPI){
        binding.rvProjectTaskRecycler.adapter = ProjectTaskAdapter(response.taskCompletedTeam as MutableList<TaskCompletedTeam>)
    }

    private fun rvFirstPlaceObserver(response: RedminerAPI) {
        binding.rvFirstPlaceTask.adapter = ProjectFirstPlaceAdapter(response.taskCompletedTeam as List<TaskCompletedTeam>)
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
        barDataSet.valueFormatter = DefaultValueFormatter(0)
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.redmine_graphic_chart_light_blue)
        val barData = BarData(barDataSet)

        binding.barChart.apply {
            animateY(1500, Easing.EaseOutBounce)
            data = barData
            setFitBars(false)
            description.isEnabled = false

            data.barWidth = 0.5f
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

            xAxis.textColor = ContextCompat.getColor(context, R.color.black)
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.main_page_blue_light)
            xAxis.valueFormatter = IndexAxisValueFormatter(model())
            xAxis.gridColor = ContextCompat.getColor(context, R.color.white)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 8f
            xAxis.axisLineWidth = 1f
            xAxis.granularity = 1f
            xAxis.axisMinimum = 0f
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