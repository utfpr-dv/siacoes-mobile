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
import br.edu.utfpr.dv.siacoes.mobile.model.Attendance
import br.edu.utfpr.dv.siacoes.mobile.model.Module
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils
import br.edu.utfpr.dv.siacoes.mobile.util.SpinnerUtils
import com.google.android.material.snackbar.Snackbar

class EditAttendanceDataFragment(private val attendance: Attendance) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_attendance_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_spinner_item, listOf(1, 2))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activity?.findViewById<Spinner>(R.id.spinner_stage)?.adapter = adapter

        activity?.findViewById<EditText>(R.id.text_date)?.setText(DateUtils().formatDate(attendance.date))
        activity?.findViewById<Spinner>(R.id.spinner_stage)?.setSelection(attendance.stage - 1)
        activity?.findViewById<EditText>(R.id.text_start_time)?.setText(DateUtils().formatTime(attendance.startTime))
        activity?.findViewById<EditText>(R.id.text_end_time)?.setText(DateUtils().formatTime(attendance.endTime))

        selectSupervisor()
    }

    fun selectSupervisor() {
        UserClient().listSupervisors(Session().getIdDepartment(), Module.SystemModule.SIGET.value, {
            SpinnerUtils().loadSpinnerUser(this.context!!, activity?.findViewById<Spinner>(R.id.spinner_supervisor)!!, it, attendance.supervisor)

            (activity as BaseActivity).hideLoading()
        }, {
            Snackbar.make(view!!, "Não foi possível carregar a lista de atividades submetidas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

}