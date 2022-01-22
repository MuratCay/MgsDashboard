package com.mgssoftware.mgsdashboard.utils

import android.annotation.SuppressLint
import com.mgssoftware.mgsdashboard.utils.Constants.DATE_FORMAT
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun convertToDateString(date: String): String {
    return SimpleDateFormat("dd-MM").format(
        SimpleDateFormat(DATE_FORMAT).parse(date)!!
    )
}


