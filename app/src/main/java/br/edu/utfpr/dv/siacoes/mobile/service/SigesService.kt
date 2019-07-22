package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.SigesConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SigesService {

    @GET("siges/config/{iddepartment}")
    fun config(@Path("iddepartment") idDepartment: Int) : Call<SigesConfig>

}