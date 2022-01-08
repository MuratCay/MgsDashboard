package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class PetnerAPI(
    @SerializedName("adoption_pets_count")
    val adoptionPetsCount: Int? = null,
    @SerializedName("comments_in_last_five_months_chart")
    val commentsInLastFiveMonthsChart: List<CommentsInLastFiveMonthsChart?>? = null,
    @SerializedName("comments_in_last_month_count")
    val commentsInLastMonthCount: Int? = null,
    @SerializedName("conversations_in_last_five_weeks_chart")
    val conversationsInLastFiveWeeksChart: List<ConversationsInLastFiveWeeksChart?>? = null,
    @SerializedName("conversations_in_last_week_count")
    val conversationsInLastWeekCount: Int? = null,
    @SerializedName("logs")
    val logs: List<Log?>? = null,
    @SerializedName("pets_count")
    val petsCount: Int? = null,
    @SerializedName("posts_in_last_five_months_chart")
    val postsInLastFiveMonthsChart: List<PostsInLastFiveMonthsChart?>? = null,
    @SerializedName("posts_in_last_month_count")
    val postsInLastMonthCount: Int? = null,
    @SerializedName("register_users")
    val registerUsers: List<RegisterUser>? = null,
    @SerializedName("users_count")
    val usersCount: Int? = null,
    @SerializedName("users_logged_ln_last_week_chart")
    val usersLoggedLnLastWeekChart: List<Any>? = null,
    @SerializedName("users_logged_ln_today_count")
    val usersLoggedLnTodayCount: Int? = null,
    @SerializedName("users_in_last_five_months_chart")
    val usersInLastFiveMonthsChart: List<UsersInLastFiveMonthsChart?>? = null,
    @SerializedName("users_in_last_month_count")
    val usersInLastMonthCount: Int? = null
)