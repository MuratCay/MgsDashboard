package com.mgssoftware.mgsdashboard.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mgssoftware.mgsdashboard.avfast.ui.viewmodel.AvfastFragmentViewModel
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.petner.ui.viewmodel.PetnerFragmentViewModel
import com.mgssoftware.mgsdashboard.reminder.openedtasks.ui.viewmodel.OpenedTasksViewModel
import com.mgssoftware.mgsdashboard.reminder.projecttasks.ui.viewmodel.ProjectTasksViewModel
import com.mgssoftware.mgsdashboard.reminder.taskcompletion.ui.viewmodel.TasksCompletionViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvfastFragmentViewModel::class.java)) {
            return AvfastFragmentViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(PetnerFragmentViewModel::class.java)) {
            return PetnerFragmentViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(TasksCompletionViewModel::class.java)) {
            return TasksCompletionViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(ProjectTasksViewModel::class.java)) {
            return ProjectTasksViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(OpenedTasksViewModel::class.java)) {
            return OpenedTasksViewModel(repository) as T
        }
        throw IllegalArgumentException("Error View Model")
    }
}