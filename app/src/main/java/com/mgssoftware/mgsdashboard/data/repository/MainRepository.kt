package com.mgssoftware.mgsdashboard.data.repository

import com.mgssoftware.mgsdashboard.avfast.data.model.AvfastAPI
import com.mgssoftware.mgsdashboard.data.service.RetrofitAPI
import com.mgssoftware.mgsdashboard.petner.data.model.PetnerAPI
import com.mgssoftware.mgsdashboard.reminder.data.model.ReminderAPI

class MainRepository(private val retrofitApi: RetrofitAPI) {
    suspend fun getAvfastUser(): AvfastAPI = retrofitApi.getAvfastUser()
    suspend fun getPetnerUser(): PetnerAPI = retrofitApi.getPetnerUser()
    suspend fun getReminderUser(): ReminderAPI = retrofitApi.getReminder()
}