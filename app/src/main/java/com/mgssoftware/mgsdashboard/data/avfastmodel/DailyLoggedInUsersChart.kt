package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class DailyLoggedInUsersChart(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("day")
    val day: String? = null,
    @SerializedName("users_count")
    val usersCount: Int? = null
)