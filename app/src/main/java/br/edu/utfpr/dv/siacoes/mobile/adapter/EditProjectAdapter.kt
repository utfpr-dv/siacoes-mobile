package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditProjectAbstractFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditProjectDataFragment
import br.edu.utfpr.dv.siacoes.mobile.model.Project

class EditProjectAdapter (private val project: Project, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_project,
        R.string.tab_text_project_abstract
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditProjectDataFragment(project)
            }
            1 -> {
                EditProjectAbstractFragment(project)
            }
            else -> {
                return EditProjectDataFragment(project)
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