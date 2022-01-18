package com.mgssoftware.mgsdashboard.redminer.openedtasks.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.redminer.data.model.RedminerAPI
import kotlinx.coroutines.launch

class OpenedTasksViewModel(private val repository: MainRepository) : ViewModel() {
    private val mutableRvFirstPlace: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<RedminerAPI>
        get() = mutableRvFirstPlace

    private val mutableRvOpenedTasks: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvOpenedTasks: LiveData<RedminerAPI>
        get() = mutableRvOpenedTasks

    fun getRvOpenedTasks() {
        viewModelScope.launch {
            mutableRvOpenedTasks.value = repository.getRedminerUser()
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getRedminerUser()
        }
    }
}