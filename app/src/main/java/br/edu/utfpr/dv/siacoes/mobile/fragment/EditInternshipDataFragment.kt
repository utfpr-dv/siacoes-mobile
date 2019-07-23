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
import br.edu.utfpr.dv.siacoes.mobile.client.CompanyClient
import br.edu.utfpr.dv.siacoes.mobile.client.UserClient
import br.edu.utfpr.dv.siacoes.mobile.model.Company
import br.edu.utfpr.dv.siacoes.mobile.model.Internship
import br.edu.utfpr.dv.siacoes.mobile.model.Module
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils
import br.edu.utfpr.dv.siacoes.mobile.util.SpinnerUtils
import com.google.android.material.snackbar.Snackbar

class EditInternshipDataFragment(private val internship: Internship) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_internship_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(Internship.InternshipType.NONREQUIRED, Internship.InternshipType.REQUIRED))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_type)?.adapter = adapter

        activity?.findViewById<Spinner>(R.id.spinner_type)?.setSelection(internship.type.value)
        activity?.findViewById<EditText>(R.id.text_total_hours)?.setText(internship.totalHours.toString())
        activity?.findViewById<EditText>(R.id.text_start_date)?.setText(DateUtils().formatDate(internship.startDate))
        activity?.findViewById<EditText>(R.id.text_end_date)?.setText(DateUtils().formatDate(internship.endDate))

        selectCompany()
        selectSupervisor()
    }

    private fun selectCompany() {
        CompanyClient().list({
            SpinnerUtils().loadSpinnerCompany(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_company)!!, it, internship.company)

            selectCompanySupervisor()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun selectCompanySupervisor() {
        UserClient().listCompanySupervisors((activity?.findViewById<Spinner>(R.id.spinner_company)?.selectedItem as Company).idCompany, {
            SpinnerUtils().loadSpinnerUser(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_company_supervisor)!!, it, internship.companySupervisor)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun selectSupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGES.value, {
            SpinnerUtils().loadSpinnerUser(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_supervisor)!!, it, internship.supervisor)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

}