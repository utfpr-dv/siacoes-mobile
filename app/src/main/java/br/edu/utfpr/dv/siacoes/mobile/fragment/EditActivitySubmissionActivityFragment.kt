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
import br.edu.utfpr.dv.siacoes.mobile.client.ActivityClient
import br.edu.utfpr.dv.siacoes.mobile.client.ActivityGroupClient
import br.edu.utfpr.dv.siacoes.mobile.model.ActivityGroup
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils
import br.edu.utfpr.dv.siacoes.mobile.util.SpinnerUtils
import com.google.android.material.snackbar.Snackbar

class EditActivitySubmissionActivityFragment(private val activitySubmission: ActivitySubmission) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_activity_submission_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(1, 2))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.adapter = adapter

        activity?.findViewById<EditText>(R.id.text_description)?.setText(activitySubmission.description)
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.setSelection(activitySubmission.semester - 1)
        activity?.findViewById<EditText>(R.id.text_year)?.setText(activitySubmission.year.toString())
        activity?.findViewById<EditText>(R.id.text_submission)?.setText(DateUtils().formatDate(activitySubmission.submissionDate))

        selectGroup()
    }

    fun selectGroup() {
        ActivityGroupClient().list({
            SpinnerUtils().loadSpinnerActivityGroup(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_group)!!, it, activitySubmission.activity?.group)

            selectActivity()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    fun selectActivity() {
        ActivityClient().list(Session().getIdDepartment(), (activity?.findViewById<Spinner>(R.id.spinner_group)?.selectedItem as ActivityGroup).idActivityGroup, {
            SpinnerUtils().loadSpinnerActivity(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_activity)!!, it, activitySubmission.activity)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

}