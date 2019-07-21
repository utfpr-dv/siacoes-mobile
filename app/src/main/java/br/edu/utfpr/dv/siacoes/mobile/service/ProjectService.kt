package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectService {

    @GET("project/find/current/{iddepartment}")
    fun findCurrent(@Path("iddepartment") idDepartment: Int) : Call<Project>
}