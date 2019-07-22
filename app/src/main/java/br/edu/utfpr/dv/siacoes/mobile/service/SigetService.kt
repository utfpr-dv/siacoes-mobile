package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.SigetConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SigetService {

    @GET("siget/config/{iddepartment}")
    fun config(@Path("iddepartment") idDepartment: Int) : Call<SigetConfig>

}