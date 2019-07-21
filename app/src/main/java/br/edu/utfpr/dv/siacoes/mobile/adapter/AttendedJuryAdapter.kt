package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.AttendedInternshipJuryListFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.AttendedThesisJuryListFragment

class AttendedJuryAdapter (private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_internship2,
        R.string.menu_siget
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                AttendedInternshipJuryListFragment()
            }
            else -> {
                return AttendedThesisJuryListFragment()
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