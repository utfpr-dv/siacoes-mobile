package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditInternshipCommentsFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditInternshipDataFragment
import br.edu.utfpr.dv.siacoes.mobile.model.Internship

class EditInternshipAdapter (private val internship: Internship, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_internship2,
        R.string.tab_text_comments
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditInternshipDataFragment(internship)
            }
            1 -> {
                EditInternshipCommentsFragment(internship)
            }
            else -> {
                return EditInternshipDataFragment(internship)
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