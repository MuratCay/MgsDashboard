package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class WeeklyTasksChart(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("month")
    val month: String,
    @SerializedName("users_count")
    val usersCount: Int
)