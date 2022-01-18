package com.mgssoftware.mgsdashboard.redminer.projecttasks.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.redminer.data.model.RedminerAPI
import kotlinx.coroutines.launch

class ProjectTasksViewModel(private val repository: MainRepository) : ViewModel() {
    private val mutableRvFirstPlace: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<RedminerAPI>
        get() = mutableRvFirstPlace

    private val mutableRvProjectTasks: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvProjectTasks: LiveData<RedminerAPI>
        get() = mutableRvProjectTasks

    fun getRvProjectTasks() {
        viewModelScope.launch {
            mutableRvProjectTasks.value = repository.getRedminerUser()
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getRedminerUser()
        }
    }
}