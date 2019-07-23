package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import androidx.fragment.app.Fragment
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class EditFinalDocumentDataFragment(private val finalDocument: FinalDocument) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_final_document_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(1, 2))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.adapter = adapter
        activity?.findViewById<Spinner>(R.id.spinner_semester)?.setSelection(finalDocument.semester - 1)

        val adapter2 = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(FinalDocument.DocumentFeedback.NONE, FinalDocument.DocumentFeedback.APPROVED, FinalDocument.DocumentFeedback.DISAPPROVED))
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_feedback)?.adapter = adapter2
        activity?.findViewById<Spinner>(R.id.spinner_feedback)?.setSelection(finalDocument.supervisorFeedback.value)

        activity?.findViewById<EditText>(R.id.text_feedback_date)?.setText(DateUtils().formatDate(finalDocument.supervisorFeedbackDate))
        activity?.findViewById<EditText>(R.id.text_submission_date)?.setText(DateUtils().formatDate(finalDocument.submissionDate))
        activity?.findViewById<EditText>(R.id.text_title)?.setText(finalDocument.title)
        activity?.findViewById<EditText>(R.id.text_year)?.setText(finalDocument.year.toString())
        activity?.findViewById<Switch>(R.id.switch_private)?.isChecked = finalDocument._private
        activity?.findViewById<Switch>(R.id.switch_company_info)?.isChecked = finalDocument.companyInfo
        activity?.findViewById<Switch>(R.id.switch_patent)?.isChecked = finalDocument.patent

        (activity as BaseActivity).hideLoading()
    }

}