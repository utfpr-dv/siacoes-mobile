package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.adapter.ProposalAppraiserListAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.ProposalClient
import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import br.edu.utfpr.dv.siacoes.mobile.model.ProposalAppraiser
import com.google.android.material.snackbar.Snackbar

class EditProposalAppraiserListFragment(private val proposal: Proposal) : Fragment() {

    private val appraiserList: MutableList<ProposalAppraiser> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_proposal_appraiser_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(ProposalAppraiser.ProposalFeedback.NONE, ProposalAppraiser.ProposalFeedback.APPROVED, ProposalAppraiser.ProposalFeedback.DISAPPROVED))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_supervisor_feedback)?.adapter = adapter
        activity?.findViewById<Spinner>(R.id.spinner_supervisor_feedback)?.setSelection(if(proposal.supervisorFeedback == ProposalAppraiser.ProposalFeedback.DISAPPROVED) 2 else proposal.supervisorFeedback.value)

        if(!Session().getSigetConfig()?.supervisorAgreement!!) {
            activity?.findViewById<TextView>(R.id.text_supervisor_feedback)?.visibility = View.GONE
            activity?.findViewById<Spinner>(R.id.spinner_supervisor_feedback)?.visibility = View.GONE
            activity?.findViewById<View>(R.id.divider_supervisor_feedback)?.visibility = View.GONE
        }

        ProposalClient().listAppraisers(proposal.idProposal, {
            appraiserList.clear()
            appraiserList.addAll(it)
            loadAppraisers()
        }, {
            Snackbar.make(view, "Não foi possível carregar a lista de avaliadores.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadAppraisers() {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.list_recyclerview)

        recyclerView?.adapter = ProposalAppraiserListAdapter(appraiserList, this.context!!) { appraiser, index ->
            /*val intent = Intent(this.context!!, EditActivitySubmissionActivity::class.java)
            intent.putExtra("activitySubmission", activitySubmission)
            startActivityForResult(intent, index, ActivityOptions.makeSceneTransitionAnimation(this.activity).toBundle())*/
        }

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        (activity as BaseActivity).hideLoading()
    }

}