package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.ActivityGroup
import retrofit2.Call
import retrofit2.http.GET

interface ActivityGroupService {

    @GET("activitygroup/list")
    fun list() : Call<List<ActivityGroup>>

}