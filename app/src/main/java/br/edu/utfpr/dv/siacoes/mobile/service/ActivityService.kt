package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Activity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ActivityService {

    @GET("activity/list/{iddepartment}/{idactivitygroup}")
    fun list(@Path("iddepartment") idDepartment: Int, @Path("idactivitygroup") idActivityGroup: Int) : Call<List<Activity>>

}