package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Thesis
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ThesisService {

    @GET("thesis/find/current/{iddepartment}")
    fun findCurrent(@Path("iddepartment") idDepartment: Int) : Call<Thesis>
}