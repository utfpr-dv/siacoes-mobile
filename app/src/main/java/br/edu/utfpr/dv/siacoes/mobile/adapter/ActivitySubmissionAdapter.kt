package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.ActivitySubmissionListFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.ActivitySubmissionSummaryFragment

class ActivitySubmissionAdapter (private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_activity_submission_sumary,
        R.string.tab_text_activity_submission_list
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ActivitySubmissionSummaryFragment()
            }
            else -> {
                return ActivitySubmissionListFragment()
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