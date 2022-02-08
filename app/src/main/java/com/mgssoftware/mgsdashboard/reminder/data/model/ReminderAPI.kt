package com.mgssoftware.mgsdashboard.reminder.data.model


import com.google.gson.annotations.SerializedName

data class ReminderAPI(
    @SerializedName("points_per_user")
    val pointsPerUser: List<Any?>? = null,
    @SerializedName("task_completed")
    val taskCompleted: List<TaskCompleted?>? = null,
    @SerializedName("task_completed_team")
    val taskCompletedTeam: ArrayList<TaskCompletedTeam?>? = null,
    @SerializedName("task_created")
    val taskCreated: List<TaskCreated?>? = null
)