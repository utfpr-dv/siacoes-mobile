package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Attendance
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class AttendanceClient {

    fun list(idProposal: Int, idSupervisor : Int, stage : Int, success: (List<Attendance>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().attendanceService().list(idProposal, idSupervisor, stage)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}