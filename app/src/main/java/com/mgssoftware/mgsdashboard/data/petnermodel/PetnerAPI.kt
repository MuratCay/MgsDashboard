package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class PetnerAPI(
    @SerializedName("adoption_pets_count")
    val adoptionPetsCount: Int,
    @SerializedName("comments_in_last_five_months_chart")
    val commentsInLastFiveMonthsChart: List<CommentsInLastFiveMonthsChart>,
    @SerializedName("comments_in_last_month_count")
    val commentsInLastMonthCount: Int,
    @SerializedName("conversations_in_last_five_weeks_chart")
    val conversationsInLastFiveWeeksChart: List<ConversationsInLastFiveWeeksChart>,
    @SerializedName("conversations_in_last_week_count")
    val conversationsInLastWeekCount: Int,
    @SerializedName("logs")
    val logs: List<Log>,
    @SerializedName("pets_count")
    val petsCount: Int,
    @SerializedName("posts_in_last_five_months_chart")
    val postsInLastFiveMonthsChart: List<PostsInLastFiveMonthsChart>,
    @SerializedName("posts_in_last_month_count")
    val postsInLastMonthCount: Int,
    @SerializedName("register_users")
    val registerUsers: List<RegisterUser>,
    @SerializedName("users_count")
    val usersCount: Int,
    @SerializedName("users_logged_ln_last_week_chart")
    val usersLoggedLnLastWeekChart: List<Any>,
    @SerializedName("users_logged_ln_today_count")
    val usersLoggedLnTodayCount: Int,
    @SerializedName("users_in_last_five_months_chart")
    val usersInLastFiveMonthsChart: List<UsersInLastFiveMonthsChart>,
    @SerializedName("users_in_last_month_count")
    val usersInLastMonthCount: Int
)