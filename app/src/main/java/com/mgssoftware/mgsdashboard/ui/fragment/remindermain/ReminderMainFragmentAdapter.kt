package com.mgssoftware.mgsdashboard.ui.fragment.remindermain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mgssoftware.mgsdashboard.reminder.openedtasks.ui.fragment.OpenedTasksFragment
import com.mgssoftware.mgsdashboard.reminder.projecttasks.ui.fragment.ProjectTasksFragment
import com.mgssoftware.mgsdashboard.reminder.taskcompletion.ui.fragment.TaskCompletionFragment
import com.mgssoftware.mgsdashboard.utils.Constants

class ReminderMainFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return Constants.NUM_TABS_REMINDER
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TaskCompletionFragment()
            1 -> OpenedTasksFragment()
            2 -> ProjectTasksFragment()
            else -> TaskCompletionFragment()
        }
    }
}