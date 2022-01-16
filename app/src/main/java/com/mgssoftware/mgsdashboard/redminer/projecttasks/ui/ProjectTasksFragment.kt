package com.mgssoftware.mgsdashboard.redminer.projecttasks.ui

import android.os.Bundle
import android.view.View
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentProjectTasksBinding
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectFirstPlace
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectFirstPlaceAdapter
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectTaskAdapter
import com.mgssoftware.mgsdashboard.redminer.projecttasks.adapters.ProjectTasksDataClass
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.CompletionFirstPlace
import com.mgssoftware.mgsdashboard.redminer.taskcompletion.adapters.TaskCompletionDataClass

class ProjectTasksFragment :
    BaseFragment<FragmentProjectTasksBinding>(FragmentProjectTasksBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFirstPlaceTask.adapter = ProjectFirstPlaceAdapter(loadFirstPlace())
        binding.rvProjectTaskRecycler.adapter = ProjectTaskAdapter(loadTaskRecycler())
    }

    private fun loadFirstPlace(): MutableList<ProjectFirstPlace> {
        return mutableListOf(
            ProjectFirstPlace(
                "1.",
                "Mobile Sprint",
                R.drawable.img_point_star,
                "90"
            ),
            ProjectFirstPlace(
                "2.",
                "Media",
                R.drawable.img_point_star_gray,
                "90"
            ),
            ProjectFirstPlace(
                "3.",
                "Frontend",
                R.drawable.img_point_star_brown,
                "90"
            ),
        )
    }
    private fun loadTaskRecycler(): MutableList<ProjectTasksDataClass>{
        return mutableListOf(
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99"),
            ProjectTasksDataClass("6.","Murat  Çay","99")
        )
    }

}