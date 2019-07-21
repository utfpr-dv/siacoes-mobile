package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.InternshipJury
import retrofit2.Call
import retrofit2.http.GET

interface InternshipJuryService {

    @GET("internshipjury/list/student")
    fun listByStudent() : Call<List<InternshipJury>>

}