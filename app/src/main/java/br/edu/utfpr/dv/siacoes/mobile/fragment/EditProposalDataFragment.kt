package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.client.UserClient
import br.edu.utfpr.dv.siacoes.mobile.model.Module
import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils
import br.edu.utfpr.dv.siacoes.mobile.util.SpinnerUtils
import com.google.android.material.snackbar.Snackbar

class EditProposalDataFragment(private val proposal: Proposal) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_proposal_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(1, 2))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.adapter = adapter
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.setSelection(proposal.semester - 1)
        activity?.findViewById<EditText>(R.id.text_title)?.setText(proposal.title)
        activity?.findViewById<EditText>(R.id.text_area)?.setText(proposal.subarea)
        activity?.findViewById<EditText>(R.id.text_year)?.setText(proposal.year.toString())
        activity?.findViewById<EditText>(R.id.text_submission_date)?.setText(DateUtils().formatDate(proposal.submissionDate))

        selectSupervisor()
        selectCosupervisor()
    }

    private fun selectSupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGET.value, {
            SpinnerUtils().loadSpinnerUser(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_supervisor)!!, it, proposal.supervisor)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(activity?.findViewById<Spinner>(R.id.spinner_supervisor)!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun selectCosupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGET.value, {
            SpinnerUtils().loadSpinnerUser(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_cosupervisor)!!, it, proposal.cosupervisor)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(activity?.findViewById<Spinner>(R.id.spinner_cosupervisor)!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

}