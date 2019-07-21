package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditActivitySubmissionActivityFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditActivitySubmissionCommentsFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditActivitySubmissionFeedbackFragment
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission

class EditActivitySubmissionAdapter (private val activitySubmission: ActivitySubmission, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_activity,
        R.string.tab_text_comments,
        R.string.tab_text_feedback
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditActivitySubmissionActivityFragment(activitySubmission)
            }
            1 -> {
                EditActivitySubmissionCommentsFragment(activitySubmission)
            }
            2 -> {
                EditActivitySubmissionFeedbackFragment(activitySubmission)
            }
            else -> {
                return EditActivitySubmissionActivityFragment(activitySubmission)
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