package com.mgssoftware.mgsdashboard.redminer.data.model


import com.google.gson.annotations.SerializedName

data class TaskCompletedTeam(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("points")
    val points: Double? = null
)