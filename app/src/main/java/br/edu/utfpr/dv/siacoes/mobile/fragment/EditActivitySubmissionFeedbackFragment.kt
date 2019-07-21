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
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class EditActivitySubmissionFeedbackFragment(private val activitySubmission: ActivitySubmission) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_activity_submission_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(ActivitySubmission.ActivityFeedback.NONE, ActivitySubmission.ActivityFeedback.APPROVED, ActivitySubmission.ActivityFeedback.DISAPPROVED))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_feedback)?.adapter = adapter

        activity?.findViewById<Spinner>(R.id.spinner_feedback)?.setSelection(activitySubmission.feedback.value)
        activity?.findViewById<EditText>(R.id.text_feedback_date)?.setText(DateUtils().formatDate(activitySubmission.feedbackDate))
        activity?.findViewById<EditText>(R.id.text_feedback_user)?.setText(activitySubmission.feedbackUser?.name)
        activity?.findViewById<EditText>(R.id.text_feedback_comments)?.setText(activitySubmission.feedbackReason)

        (activity as BaseActivity).hideLoading()
    }

}