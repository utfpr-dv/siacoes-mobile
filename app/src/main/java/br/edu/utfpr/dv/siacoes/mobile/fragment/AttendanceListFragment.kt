package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity

class AttendanceListFragment : Fragment() {

    //private val activitySubmissionList: MutableList<ActivitySubmission> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_attendance_list, container, false)

        (activity as BaseActivity).showLoading()

        /*ActivitySubmissionClient().list(Session().getIdDepartment(), feedback, {
            activitySubmissionList.addAll(it)
            loadItems()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })*/
    }

    private fun loadItems() {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.list_recyclerview)

        /*recyclerView?.adapter = ActivitySubmissionListAdapter(activitySubmissionList, this.context!!) { activitySubmission, index ->
            val intent = Intent(this.context!!, EditActivitySubmissionActivity::class.java)
            intent.putExtra("activitySubmission", activitySubmission)
            startActivityForResult(intent, index, ActivityOptions.makeSceneTransitionAnimation(this.activity).toBundle())
        }*/

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        (activity as BaseActivity).hideLoading()
    }

}