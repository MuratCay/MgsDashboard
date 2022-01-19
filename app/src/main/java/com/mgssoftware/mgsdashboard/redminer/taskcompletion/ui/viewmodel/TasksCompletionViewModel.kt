package com.mgssoftware.mgsdashboard.redminer.taskcompletion.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.redminer.data.model.RedminerAPI
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCompleted
import kotlinx.coroutines.launch

class TasksCompletionViewModel(private val repository: MainRepository) : ViewModel() {

    private val mutableRvFirstPlace: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvFirstPlace: LiveData<RedminerAPI>
        get() = mutableRvFirstPlace

    private val mutableRvTaskCompletion: MutableLiveData<RedminerAPI> = MutableLiveData()
    val rvTaskCompletion: LiveData<RedminerAPI>
        get() = mutableRvTaskCompletion

    fun getRvTaskCompletion() {
        viewModelScope.launch {
            mutableRvTaskCompletion.value = repository.getRedminerUser()
        }
    }

    fun getRvFirstPlace() {
        viewModelScope.launch {
            mutableRvFirstPlace.value = repository.getRedminerUser()
        }
    }
}