package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditFinalDocumentAbstract2Fragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditFinalDocumentAbstractFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditFinalDocumentCommentsFragment
import br.edu.utfpr.dv.siacoes.mobile.fragment.EditFinalDocumentDataFragment
import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument

class EditFinalDocumentAdapter (private val finalDocument: FinalDocument, private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_final_document_data,
        R.string.tab_text_final_document_abstract,
        R.string.tab_text_final_document_abstract2,
        R.string.tab_text_final_document_comments
    )

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                EditFinalDocumentDataFragment(finalDocument)
            }
            1 -> {
                EditFinalDocumentAbstractFragment(finalDocument)
            }
            2 -> {
                EditFinalDocumentAbstract2Fragment(finalDocument)
            }
            3 -> {
                EditFinalDocumentCommentsFragment(finalDocument)
            }
            else -> {
                return EditFinalDocumentDataFragment(finalDocument)
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