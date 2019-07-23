package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.activity.*
import br.edu.utfpr.dv.siacoes.mobile.client.ProjectClient
import br.edu.utfpr.dv.siacoes.mobile.client.ProposalClient
import br.edu.utfpr.dv.siacoes.mobile.client.ThesisClient
import com.google.android.material.snackbar.Snackbar

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

        activity?.findViewById<LinearLayout>(R.id.layout_register)?.setOnClickListener{
            clickSupervisorRegister(activity?.findViewById<LinearLayout>(R.id.layout_register)!!)
        }

        activity?.findViewById<LinearLayout>(R.id.layout_proposal)?.setOnClickListener{
            clickProposal(activity?.findViewById<LinearLayout>(R.id.layout_proposal)!!)
        }

        activity?.findViewById<LinearLayout>(R.id.layout_project)?.setOnClickListener{
            clickProject(activity?.findViewById<LinearLayout>(R.id.layout_project)!!)
        }

        activity?.findViewById<LinearLayout>(R.id.layout_thesis)?.setOnClickListener{
            clickThesis(activity?.findViewById<LinearLayout>(R.id.layout_thesis)!!)
        }
    }

    private fun clickSupervisorRegister(view: View) {
        ProposalClient().findCurrent(Session().getIdDepartment(), {
            val intent = Intent(this.context, EditSupervisorRegisterActivity::class.java)
            intent.putExtra("proposal", it)
            startActivityForResult(intent, 0, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }, {
            Snackbar.make(view, "Não foi possível carregar o registro de orientação.", Snackbar.LENGTH_LONG).show()

        })
    }

    private fun clickProposal(view: View) {
        ProposalClient().findCurrent(Session().getIdDepartment(), {
            val intent = Intent(this.context, EditProposalActivity::class.java)
            intent.putExtra("proposal", it)
            startActivityForResult(intent, 0, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }, {
            Snackbar.make(view, "Não foi possível carregar a Proposta de TCC 1.", Snackbar.LENGTH_LONG).show()

        })
    }

    private fun clickProject(view: View) {
        ProjectClient().findCurrent(Session().getIdDepartment(), {
            val intent = Intent(this.context, EditProjectActivity::class.java)
            intent.putExtra("project", it)
            startActivityForResult(intent, 0, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }, {
            Snackbar.make(view, "Não foi possível carregar o Projeto de TCC 1.", Snackbar.LENGTH_LONG).show()

        })
    }

    private fun clickThesis(view: View) {
        ThesisClient().findCurrent(Session().getIdDepartment(), {
            val intent = Intent(this.context, EditThesisActivity::class.java)
            intent.putExtra("thesis", it)
            startActivityForResult(intent, 0, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }, {
            Snackbar.make(view, "Não foi possível carregar a Monografia de TCC 2.", Snackbar.LENGTH_LONG).show()

        })
    }

}