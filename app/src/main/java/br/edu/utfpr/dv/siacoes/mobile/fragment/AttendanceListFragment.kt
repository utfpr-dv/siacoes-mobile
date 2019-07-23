package br.edu.utfpr.dv.siacoes.mobile.fragment

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
import br.edu.utfpr.dv.siacoes.mobile.activity.EditAttendanceActivity
import br.edu.utfpr.dv.siacoes.mobile.adapter.AttendanceListAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.AttendanceClient
import br.edu.utfpr.dv.siacoes.mobile.client.ProposalClient
import br.edu.utfpr.dv.siacoes.mobile.model.Attendance
import br.edu.utfpr.dv.siacoes.mobile.model.User
import com.google.android.material.snackbar.Snackbar

class AttendanceListFragment : Fragment() {

    private val attendanceList: MutableList<Attendance> = mutableListOf()
    private var idProposal : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_attendance_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        ProposalClient().findCurrentId(Session().getIdDepartment(), {
            this.idProposal = it
            this.loadSupervisors()
        }, {
            Snackbar.make(view, "Não foi possível encontrar o registro de orientação.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadSupervisors() {
        ProposalClient().listSupervisors(this.idProposal, {
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, it)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            activity?.findViewById<Spinner>(R.id.filter_spinner)?.adapter = adapter

            activity?.findViewById<Spinner>(R.id.filter_spinner)?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    // either one will work as well
                    // val item = parent.getItemAtPosition(position) as String
                    var item : User? = adapter.getItem(position)

                    getItems(item?.idUser!!)
                }
            }
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de orientadores.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun getItems(idSupervisor : Int) {
        (activity as BaseActivity).showLoading()

        AttendanceClient().list(this.idProposal, idSupervisor, 0, {
            attendanceList.clear()
            attendanceList.addAll(it)
            loadItems()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de reuniões.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadItems() {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.list_recyclerview)

        recyclerView?.adapter = AttendanceListAdapter(attendanceList, this.context!!) { attendance, index ->
            val intent = Intent(this.context!!, EditAttendanceActivity::class.java)
            intent.putExtra("attendance", attendance)
            startActivityForResult(intent, index, ActivityOptions.makeSceneTransitionAnimation(this.activity).toBundle())
        }

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        (activity as BaseActivity).hideLoading()
    }

}