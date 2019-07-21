package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Attendance
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AttendanceService {

    @GET("attendance/list/{idproposal}/{idsupervisor}/{stage}")
    fun list(@Path("idproposal") idProposal: Int, @Path("idsupervisor") idSupervisor: Int, @Path("stage") stage: Int) : Call<List<Attendance>>

}