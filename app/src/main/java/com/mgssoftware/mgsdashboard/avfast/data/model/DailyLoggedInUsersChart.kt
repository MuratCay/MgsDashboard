package com.mgssoftware.mgsdashboard.avfast.data.model


import com.google.gson.annotations.SerializedName

data class DailyLoggedInUsersChart(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("day")
    val day: String? = null,
    @SerializedName("count")
    val usersCount: Int? = null
)