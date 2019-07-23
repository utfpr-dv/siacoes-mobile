package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.activity.EditActivitySubmissionActivity
import br.edu.utfpr.dv.siacoes.mobile.adapter.ActivitySubmissionListAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.ActivitySubmissionClient
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import com.google.android.material.snackbar.Snackbar

class ActivitySubmissionListFragment : Fragment() {

    private val activitySubmissionList: MutableList<ActivitySubmission> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activity_submission_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(ActivitySubmission.ActivityFeedback.NONE, ActivitySubmission.ActivityFeedback.APPROVED, ActivitySubmission.ActivityFeedback.DISAPPROVED))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.filter_spinner)?.adapter = adapter

        activity?.findViewById<Spinner>(R.id.filter_spinner)?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                var item : ActivitySubmission.ActivityFeedback? = adapter.getItem(position)

                if(item == null) {
                    item = ActivitySubmission.ActivityFeedback.NONE
                }

                getItems(item.value)
            }
        }
    }

    private fun getItems(feedback : Int) {
        (activity as BaseActivity).showLoading()

        ActivitySubmissionClient().list(Session().getIdDepartment(), feedback, {
            activitySubmissionList.clear()
            activitySubmissionList.addAll(it)
            loadItems()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadItems() {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.list_recyclerview)

        recyclerView?.adapter = ActivitySubmissionListAdapter(activitySubmissionList, this.context!!) { activitySubmission, index ->
            val intent = Intent(this.context!!, EditActivitySubmissionActivity::class.java)
            intent.putExtra("activitySubmission", activitySubmission)
            startActivityForResult(intent, index, ActivityOptions.makeSceneTransitionAnimation(this.activity).toBundle())
        }

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        (activity as BaseActivity).hideLoading()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            activitySubmissionList[requestCode] = data?.getSerializableExtra("activitySubmission") as ActivitySubmission
            loadItems()
        }
    }

}