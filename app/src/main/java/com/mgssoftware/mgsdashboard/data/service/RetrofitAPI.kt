package com.mgssoftware.mgsdashboard.data.service

import com.mgssoftware.mgsdashboard.avfast.data.model.AvfastAPI
import com.mgssoftware.mgsdashboard.petner.data.model.PetnerAPI
import com.mgssoftware.mgsdashboard.redminer.data.model.RedminerAPI
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("api/v1/screen")
    suspend fun getAvfastUser(
        @Query("token") token: String = "DfP3BkL97zZZnRX1ecgAe8"
    ): AvfastAPI

    @GET("api/v1/admin/screen_dashboard")
    suspend fun getPetnerUser(): PetnerAPI

    @GET("storypoints")
    suspend fun getRedminer(): RedminerAPI
}