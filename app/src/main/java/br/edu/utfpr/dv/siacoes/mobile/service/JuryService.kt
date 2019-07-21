package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Jury
import retrofit2.Call
import retrofit2.http.GET

interface JuryService {

    @GET("jury/list/student")
    fun listByStudent() : Call<List<Jury>>

}