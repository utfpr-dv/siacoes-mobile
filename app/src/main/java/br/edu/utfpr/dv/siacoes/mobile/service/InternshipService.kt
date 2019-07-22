package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Internship
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InternshipService {

    @GET("internship/list/{iddepartment}")
    fun list(@Path("iddepartment") idDepartment: Int) : Call<List<Internship>>

    @GET("internship/find/{idinternship}")
    fun find(@Path("idinternship") idDepartment: Int) : Call<Internship>

}