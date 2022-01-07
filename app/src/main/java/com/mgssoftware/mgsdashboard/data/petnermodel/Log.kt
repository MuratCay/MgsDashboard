package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class Log(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String
)