package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import br.edu.utfpr.dv.siacoes.mobile.model.ProposalAppraiser
import br.edu.utfpr.dv.siacoes.mobile.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProposalService {

    @GET("proposal/have/{iddepartment}")
    fun haveProposal(@Path("iddepartment") idDepartment: Int) : Call<Boolean>

    @GET("proposal/find/current/{iddepartment}")
    fun findCurrent(@Path("iddepartment") idDepartment: Int) : Call<Proposal>

    @GET("proposal/find/current/id/{iddepartment}")
    fun findCurrentId(@Path("iddepartment") idDepartment: Int) : Call<Int>

    @GET("proposal/list/supervisors/{idproposal}")
    fun listSupervisors(@Path("idproposal") idProposal: Int) : Call<List<User>>

    @GET("proposal/supervisor/current/{idproposal}")
    fun findCurrentSupervisor(@Path("idproposal") idProposal: Int) : Call<User>

    @GET("proposal/list/appraisers/{idproposal}")
    fun listAppraisers(@Path("idproposal") idProposal: Int) : Call<List<ProposalAppraiser>>

}