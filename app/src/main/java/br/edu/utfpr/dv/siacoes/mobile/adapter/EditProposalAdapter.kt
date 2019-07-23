package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditProposalAppraiserListFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditProposalDataFragment
import br.edu.utfpr.dv.siacoes.mobile.model.Proposal

class EditProposalAdapter (private val proposal: Proposal, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_proposal,
        R.string.tab_text_appraiser_list
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditProposalDataFragment(proposal)
            }
            1 -> {
                EditProposalAppraiserListFragment(proposal)
            }
            else -> {
                return EditProposalDataFragment(proposal)
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