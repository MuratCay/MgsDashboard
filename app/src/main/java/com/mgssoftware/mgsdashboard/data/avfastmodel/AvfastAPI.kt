package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class AvfastAPI(
    @SerializedName("daily_logged_in_users_chart")
    val dailyLoggedInUsersChart: List<DailyLoggedInUsersChart?>? = null,
    @SerializedName("daily_logged_in_users_count")
    val dailyLoggedInUsersCount: Int? = null,
    @SerializedName("logs")
    val logs: List<Log?>? = null,
    @SerializedName("monthly_total_users_chart")
    val monthlyTotalUsersChart: List<MonthlyTotalUsersChart?>? = null,
    @SerializedName("monthly_total_users_count")
    val monthlyTotalUsersCount: Int? = null,
    @SerializedName("online_users_count")
    val onlineUsersCount: Int? = null,
    @SerializedName("register_users")
    val registerUsers: List<RegisterUser?>? = null,
    @SerializedName("users_count")
    val usersCount: Int? = null,
    @SerializedName("weekly_applied_tasks_chart")
    val weeklyAppliedTasksChart: List<WeeklyAppliedTasksChart?>? = null,
    @SerializedName("weekly_applied_tasks_count")
    val weeklyAppliedTasksCount: Int? = null,
    @SerializedName("weekly_done_tasks_chart")
    val weeklyDoneTasksChart: List<WeeklyDoneTasksChart?>? = null,
    @SerializedName("weekly_done_tasks_count")
    val weeklyDoneTasksCount: Int? = null,
    @SerializedName("weekly_evaluated_tasks_chart")
    val weeklyEvaluatedTasksChart: List<WeeklyEvaluatedTasksChart?>? = null,
    @SerializedName("weekly_evaluated_tasks_count")
    val weeklyEvaluatedTasksCount: Int? = null,
    @SerializedName("weekly_tasks_chart")
    val weeklyTasksChart: List<WeeklyTasksChart?>? = null,
    @SerializedName("weekly_tasks_count")
    val weeklyTasksCount: Int? = null
)