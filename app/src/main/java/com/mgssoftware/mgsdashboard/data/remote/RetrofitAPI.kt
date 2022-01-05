package com.mgssoftware.mgsdashboard.data.remote

import com.mgssoftware.mgsdashboard.data.avfastmodel.AvfastAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("api/v1/screen")
    fun getAvfastUser(
        @Query("token") token: String = "DfP3BkL97zZZnRX1ecgAe8"
    ): Call<AvfastAPI>
}