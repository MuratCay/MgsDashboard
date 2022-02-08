package com.mgssoftware.mgsdashboard.reminder.openedtasks.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.reminder.data.model.ReminderAPI
import kotlinx.coroutines.launch

class OpenedTasksViewModel(private val repository: MainRepository) : ViewModel() {
    private val mutableRvFirstPlace: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<ReminderAPI>
        get() = mutableRvFirstPlace

    private val mutableRvOpenedTasks: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvOpenedTasks: LiveData<ReminderAPI>
        get() = mutableRvOpenedTasks

    fun getRvOpenedTasks() {
        viewModelScope.launch {
            /* val response = repository.getReminderUser()
             val openedTasksList = response.taskCreated?.sortedByDescending { it?.points }
                 ?.filterIndexed { index, _ ->
                     index != 0 && index != 1 && index != 3
                 }*/
            mutableRvOpenedTasks.postValue(repository.getReminderUser())
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getReminderUser()
        }
    }
}
