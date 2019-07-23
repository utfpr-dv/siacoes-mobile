package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.*
import br.edu.utfpr.dv.siacoes.mobile.model.Attendance

class EditAttendanceAdapter (private val attendance: Attendance, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_attendance2,
        R.string.tab_text_attendance_comments,
        R.string.tab_text_attendance_next_meeting
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditAttendanceDataFragment(attendance)
            }
            1 -> {
                EditAttendanceCommentsFragment(attendance)
            }
            2 -> {
                EditAttendanceNextMeetingFragment(attendance)
            }
            else -> {
                return EditAttendanceDataFragment(attendance)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}