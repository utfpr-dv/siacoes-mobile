package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session

class MyThesisFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_thesis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!Session().getSigetConfig()?.registerProposal!!) {
            activity?.findViewById<LinearLayout>(R.id.layout_proposal)?.visibility = View.GONE
            activity?.findViewById<View>(R.id.view_proposal)?.visibility = View.GONE
        }

        if(!Session().getSigetConfig()?.requestFinalDocumentStage1!!) {
            activity?.findViewById<LinearLayout>(R.id.layout_final_project)?.visibility = View.GONE
            activity?.findViewById<View>(R.id.view_final_project)?.visibility = View.GONE
        }
    }

}