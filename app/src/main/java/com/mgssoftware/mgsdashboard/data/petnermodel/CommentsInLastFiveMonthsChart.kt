package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class CommentsInLastFiveMonthsChart(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("month")
    val month: String? = null
)