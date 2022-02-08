package com.mgssoftware.mgsdashboard.reminder.projecttasks.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.reminder.data.model.ReminderAPI
import kotlinx.coroutines.launch

class ProjectTasksViewModel(private val repository: MainRepository) : ViewModel() {
    private val mutableRvFirstPlace: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<ReminderAPI>
        get() = mutableRvFirstPlace

    private val mutableRvProjectTasks: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvProjectTasks: LiveData<ReminderAPI>
        get() = mutableRvProjectTasks

    fun getRvProjectTasks() {
        viewModelScope.launch {
            mutableRvProjectTasks.value = repository.getReminderUser()
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getReminderUser()
        }
    }
}