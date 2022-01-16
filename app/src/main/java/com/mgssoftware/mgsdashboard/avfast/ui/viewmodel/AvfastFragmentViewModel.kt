package com.mgssoftware.mgsdashboard.avfast.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.avfast.data.model.AvfastAPI
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import kotlinx.coroutines.launch

class AvfastFragmentViewModel(private val repository: MainRepository) : ViewModel() {

    private val mutableNumberOfUsers: MutableLiveData<AvfastAPI> = MutableLiveData()
    val numberOfUsers: LiveData<AvfastAPI>
        get() = mutableNumberOfUsers

    private val mutableNumberOfPeopleOnline: MutableLiveData<AvfastAPI> = MutableLiveData()
    val numberOfPeopleOnline: LiveData<AvfastAPI>
        get() = mutableNumberOfPeopleOnline

    private val mutableNumberOfRegistered: MutableLiveData<AvfastAPI> = MutableLiveData()
    val numberOfRegistered: LiveData<AvfastAPI>
        get() = mutableNumberOfRegistered

    private val mutableNumberOfRecentEvents: MutableLiveData<AvfastAPI> = MutableLiveData()
    val numberOfRecentEvents: LiveData<AvfastAPI>
        get() = mutableNumberOfRecentEvents

    private val mutableRvAssignment: MutableLiveData<AvfastAPI> = MutableLiveData()
    val rvAssignment: LiveData<AvfastAPI>
        get() = mutableRvAssignment

    private val mutableRvRegistrants: MutableLiveData<AvfastAPI> = MutableLiveData()
    val rvRegistrants: LiveData<AvfastAPI>
        get() = mutableRvRegistrants

    private val mutableUpdateAvfastRecycler: MutableLiveData<AvfastAPI> = MutableLiveData()
    val updateAvfastRecycler: LiveData<AvfastAPI>
        get() = mutableUpdateAvfastRecycler

    fun getRvRegistrants() {
        viewModelScope.launch {
            mutableRvRegistrants.value = repository.getAvfastUser()
        }
    }

    fun getUpdateAvfastRecycler() {
        viewModelScope.launch {
            mutableUpdateAvfastRecycler.value = repository.getAvfastUser()
        }
    }

    fun getNumberOfUsers() {
        viewModelScope.launch {
            mutableNumberOfUsers.value = repository.getAvfastUser()
        }
    }

    fun getNumberOfPeopleOnline() {
        viewModelScope.launch {
            mutableNumberOfPeopleOnline.value = repository.getAvfastUser()
        }
    }

    fun getNumberOfRegistered() {
        viewModelScope.launch {
            mutableNumberOfRegistered.value = repository.getAvfastUser()
        }
    }

    fun getNumberOfRecentEvents() {
        viewModelScope.launch {
            mutableNumberOfRecentEvents.value = repository.getAvfastUser()
        }
    }

    fun getRvAssignment() {
        viewModelScope.launch {
            mutableRvAssignment.value = repository.getAvfastUser()
        }
    }
}
