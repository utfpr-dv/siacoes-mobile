package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.client.UserClient
import br.edu.utfpr.dv.siacoes.mobile.model.Module
import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils
import br.edu.utfpr.dv.siacoes.mobile.util.SpinnerUtils
import com.google.android.material.snackbar.Snackbar

class EditSupervisorRegisterActivity : BaseActivity("Registro de Orientação",true, false, false, null) {

    private var proposal : Proposal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_supervisor_register)
        val a = intent.getSerializableExtra("proposal") as Proposal
        proposal = a

        this.showLoading()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf(1, 2))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.spinner_semester)?.adapter = adapter
        findViewById<Spinner>(R.id.spinner_semester)?.setSelection(proposal?.semester!! - 1)
        findViewById<EditText>(R.id.text_title).setText(proposal?.title)
        findViewById<EditText>(R.id.text_area).setText(proposal?.subarea)
        findViewById<EditText>(R.id.text_year).setText(proposal?.year.toString())
        findViewById<EditText>(R.id.text_submission_date).setText(DateUtils().formatDate(proposal?.submissionDate))

        selectSupervisor()
        selectCosupervisor()
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

    private fun selectSupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGET.value, {
            SpinnerUtils().loadSpinnerUser(this, findViewById<Spinner>(R.id.spinner_supervisor)!!, it, proposal?.supervisor)

            hideLoading()
        }, {
            Snackbar.make(findViewById<Spinner>(R.id.spinner_supervisor), "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            hideLoading()
        })
    }

    private fun selectCosupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGET.value, {
            SpinnerUtils().loadSpinnerUser(this, findViewById<Spinner>(R.id.spinner_cosupervisor)!!, it, proposal?.cosupervisor)

            hideLoading()
        }, {
            Snackbar.make(findViewById<Spinner>(R.id.spinner_cosupervisor), "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            hideLoading()
        })
    }

}