package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.SigacConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SigacService {

    @GET("sigac/config/{iddepartment}")
    fun config(@Path("iddepartment") idDepartment: Int) : Call<SigacConfig>

}