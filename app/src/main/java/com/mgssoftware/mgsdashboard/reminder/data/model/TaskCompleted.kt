package com.mgssoftware.mgsdashboard.reminder.data.model


import com.google.gson.annotations.SerializedName

data class TaskCompleted(
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("points")
    val points: Double? = null
)