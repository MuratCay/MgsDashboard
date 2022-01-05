package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class AvfastAPI(
    @SerializedName("daily_logged_in_users_chart")
    val dailyLoggedInUsersChart: DailyLoggedInUsersChart,
    @SerializedName("daily_logged_in_users_count")
    val dailyLoggedInUsersCount: Int,
    @SerializedName("logs")
    val logs: List<Log>,
    @SerializedName("monthly_total_users_chart")
    val monthlyTotalUsersChart: List<MonthlyTotalUsersChart>,
    @SerializedName("monthly_total_users_count")
    val monthlyTotalUsersCount: Int,
    @SerializedName("online_users_count")
    val onlineUsersCount: Int,
    @SerializedName("register_users")
    val registerUsers: List<RegisterUser>,
    @SerializedName("users_count")
    val usersCount: Int,
    @SerializedName("weekly_applied_tasks_chart")
    val weeklyAppliedTasksChart: List<WeeklyAppliedTasksChart>,
    @SerializedName("weekly_applied_tasks_count")
    val weeklyAppliedTasksCount: Int,
    @SerializedName("weekly_done_tasks_chart")
    val weeklyDoneTasksChart: List<WeeklyDoneTasksChart>,
    @SerializedName("weekly_done_tasks_count")
    val weeklyDoneTasksCount: Int,
    @SerializedName("weekly_evaluated_tasks_chart")
    val weeklyEvaluatedTasksChart: List<WeeklyEvaluatedTasksChart>,
    @SerializedName("weekly_evaluated_tasks_count")
    val weeklyEvaluatedTasksCount: Int,
    @SerializedName("weekly_tasks_chart")
    val weeklyTasksChart: List<WeeklyTasksChart>,
    @SerializedName("weekly_tasks_count")
    val weeklyTasksCount: Int
)