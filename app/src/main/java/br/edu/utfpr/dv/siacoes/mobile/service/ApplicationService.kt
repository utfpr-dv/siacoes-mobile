package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.AppConfig
import retrofit2.Call
import retrofit2.http.GET

interface ApplicationService {

    @GET("application/config")
    fun config() : Call<AppConfig>

}