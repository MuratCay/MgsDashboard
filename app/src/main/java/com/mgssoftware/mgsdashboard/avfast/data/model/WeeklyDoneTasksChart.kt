package com.mgssoftware.mgsdashboard.avfast.data.model


import com.google.gson.annotations.SerializedName

data class WeeklyDoneTasksChart(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("month")
    val month: String? = null,
    @SerializedName("count")
    val usersCount: Int? = null
)