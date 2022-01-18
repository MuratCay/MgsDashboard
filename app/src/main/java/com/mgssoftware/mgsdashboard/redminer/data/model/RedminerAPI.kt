package com.mgssoftware.mgsdashboard.redminer.data.model


import com.google.gson.annotations.SerializedName

data class RedminerAPI(
    @SerializedName("points_per_user")
    val pointsPerUser: List<Any?>? = null,
    @SerializedName("task_completed")
    val taskCompleted: List<TaskCompleted?>? = null,
    @SerializedName("task_completed_team")
    val taskCompletedTeam: List<TaskCompletedTeam?>? = null,
    @SerializedName("task_created")
    val taskCreated: List<TaskCreated?>? = null
)