package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.adapter.ActivitySubmissionSummaryAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.ActivitySubmissionClient
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmissionSummary
import com.google.android.material.snackbar.Snackbar

class ActivitySubmissionSummaryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activity_submission_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        ActivitySubmissionClient().summary(Session().getIdDepartment(), {
            loadSummary(it)
        }, {
            Snackbar.make(view, "Não foi possível carregar o resumo de pontuação.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadSummary(submissionSummary : List<ActivitySubmissionSummary>) {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.summary_recyclerview)

        recyclerView?.adapter = ActivitySubmissionSummaryAdapter(submissionSummary, this.context!!)

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        activity?.findViewById<TextView>(R.id.score)?.text = ActivitySubmissionClient().getTotalScore(submissionSummary).toString() + " Ponto(s)"
        activity?.findViewById<TextView>(R.id.situation)?.text = ActivitySubmissionClient().getSituation(submissionSummary, 70)

        activity?.findViewById<CardView>(R.id.card_summary)?.visibility = View.VISIBLE

        (activity as BaseActivity).hideLoading()
    }

}