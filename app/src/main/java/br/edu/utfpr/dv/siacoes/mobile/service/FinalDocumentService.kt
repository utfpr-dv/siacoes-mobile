package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FinalDocumentService {

    @GET("finaldocument/find/{iddepartment}/{stage}")
    fun find(@Path("iddepartment") idDepartment: Int, @Path("stage") stage: Int) : Call<FinalDocument>

}