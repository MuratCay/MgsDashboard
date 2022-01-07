package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class UsersİnLastFiveMonthsChart(
    @SerializedName("count")
    val count: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("month")
    val month: String
)