package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Company
import retrofit2.Call
import retrofit2.http.GET

interface CompanyService {

    @GET("company/list")
    fun list() : Call<List<Company>>

}