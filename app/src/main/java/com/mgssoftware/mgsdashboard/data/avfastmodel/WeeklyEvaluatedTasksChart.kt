package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class WeeklyEvaluatedTasksChart(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("month")
    val month: String? = null,
    @SerializedName("count")
    val usersCount: Int? = null
)