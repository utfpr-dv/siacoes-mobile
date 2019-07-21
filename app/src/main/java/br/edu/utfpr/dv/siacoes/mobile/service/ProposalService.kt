package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProposalService {

    @GET("proposal/have/{iddepartment}")
    fun haveProposal(@Path("iddepartment") idDepartment: Int) : Call<Boolean>

    @GET("proposal/find/current/{iddepartment}")
    fun findCurrent(@Path("iddepartment") idDepartment: Int) : Call<Proposal>

}