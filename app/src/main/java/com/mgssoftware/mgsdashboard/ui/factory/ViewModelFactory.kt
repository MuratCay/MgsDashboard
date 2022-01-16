package com.mgssoftware.mgsdashboard.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mgssoftware.mgsdashboard.avfast.ui.viewmodel.AvfastFragmentViewModel
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.petner.ui.viewmodel.PetnerFragmentViewModel

class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvfastFragmentViewModel::class.java)) {
            return AvfastFragmentViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(PetnerFragmentViewModel::class.java)) {
            return PetnerFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Error View Model")
    }
}