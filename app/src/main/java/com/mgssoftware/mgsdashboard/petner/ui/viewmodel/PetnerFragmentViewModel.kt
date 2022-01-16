package com.mgssoftware.mgsdashboard.petner.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.petner.data.model.PetnerAPI
import kotlinx.coroutines.launch

class PetnerFragmentViewModel(private val repository: MainRepository) : ViewModel() {

    private val mutableNumberOfUsers: MutableLiveData<PetnerAPI> = MutableLiveData()
    val numberOfUsers: LiveData<PetnerAPI>
        get() = mutableNumberOfUsers

    private val mutableUpdatePetnerRecycler: MutableLiveData<PetnerAPI> = MutableLiveData()
    val updatePetnerRecycler: LiveData<PetnerAPI>
        get() = mutableUpdatePetnerRecycler

    private val mutableRvAssignment: MutableLiveData<PetnerAPI> = MutableLiveData()
    val rvAssignment: LiveData<PetnerAPI>
        get() = mutableRvAssignment

    private val mutableRvRegistrants: MutableLiveData<PetnerAPI> = MutableLiveData()
    val rvRegistrants: LiveData<PetnerAPI>
        get() = mutableRvRegistrants

    private val mutableCurrentNumberOfPets: MutableLiveData<PetnerAPI> = MutableLiveData()
    val currentNumberOfPets: LiveData<PetnerAPI>
        get() = mutableCurrentNumberOfPets

    private val mutableCurrentNumberOfAdoptions: MutableLiveData<PetnerAPI> = MutableLiveData()
    val currentNumberOfAdoptions: LiveData<PetnerAPI>
        get() = mutableCurrentNumberOfAdoptions

    private val mutableNumberOfRegistered: MutableLiveData<PetnerAPI> = MutableLiveData()
    val numberOfRegistered: LiveData<PetnerAPI>
        get() = mutableNumberOfRegistered

    private val mutableNumberOfRecentEvents: MutableLiveData<PetnerAPI> = MutableLiveData()
    val numberOfRecentEvents: LiveData<PetnerAPI>
        get() = mutableNumberOfRecentEvents


    fun getNumberOfRecentEvents() {
        viewModelScope.launch {
            mutableNumberOfRecentEvents.value = repository.getPetnerUser()
        }
    }

    fun getNumberOfRegistered() {
        viewModelScope.launch {
            mutableNumberOfRegistered.value = repository.getPetnerUser()
        }
    }

    fun getCurrentNumberOfAdoptions() {
        viewModelScope.launch {
            mutableCurrentNumberOfAdoptions.value = repository.getPetnerUser()
        }
    }

    fun getCurrentNumberOfPets() {
        viewModelScope.launch {
            mutableCurrentNumberOfPets.value = repository.getPetnerUser()
        }
    }

    fun getRvRegistrants() {
        viewModelScope.launch {
            mutableRvRegistrants.value = repository.getPetnerUser()
        }
    }

    fun getRvAssignment() {
        viewModelScope.launch {
            mutableRvAssignment.value = repository.getPetnerUser()
        }
    }

    fun getUpdatePetnerRecycler() {
        viewModelScope.launch {
            mutableUpdatePetnerRecycler.value = repository.getPetnerUser()
        }
    }

    fun getNumberOfUsers() {
        viewModelScope.launch {
            mutableNumberOfUsers.value = repository.getPetnerUser()
        }
    }
}