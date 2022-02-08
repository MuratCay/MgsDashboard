package com.mgssoftware.mgsdashboard.reminder.taskcompletion.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.reminder.data.model.ReminderAPI
import kotlinx.coroutines.launch

class TasksCompletionViewModel(private val repository: MainRepository) : ViewModel() {

    private val mutableRvFirstPlace: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<ReminderAPI>
        get() = mutableRvFirstPlace

    private val mutableRvTaskCompletion: MutableLiveData<ReminderAPI> = MutableLiveData()
    val rvTaskCompletion: LiveData<ReminderAPI>
        get() = mutableRvTaskCompletion

    fun getRvTaskCompletion() {
        viewModelScope.launch {
            mutableRvTaskCompletion.value = repository.getReminderUser()
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getReminderUser()
        }
    }
}