package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmissionSummary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ActivitySubmissionService {

    @GET("activitysubmission/summary/{iddepartment}")
    fun summary(@Path("iddepartment") idDepartment: Int) : Call<List<ActivitySubmissionSummary>>

    @GET("activitysubmission/list/{iddepartment}/{feedback}")
    fun list(@Path("iddepartment") idDepartment: Int, @Path("feedback") feedback: Int) : Call<List<ActivitySubmission>>

}