package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import br.edu.utfpr.dv.siacoes.mobile.model.ProposalAppraiser
import br.edu.utfpr.dv.siacoes.mobile.model.User
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class ProposalClient {

    fun haveProposal(idDepartment: Int, success: (Boolean) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().haveProposal(idDepartment)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun findCurrent(idDepartment: Int, success: (Proposal) -> Unit,
                     failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().findCurrent(idDepartment)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun findCurrentId(idDepartment: Int, success: (Int) -> Unit,
                    failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().findCurrentId(idDepartment)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun listSupervisors(idProposal: Int, success: (List<User>) -> Unit,
                        failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().listSupervisors(idProposal)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun findCurrentSupervisor(idProposal: Int, success: (User) -> Unit,
                        failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().findCurrentSupervisor(idProposal)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun listAppraisers(idProposal: Int, success: (List<ProposalAppraiser>) -> Unit,
                        failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().proposalService().listAppraisers(idProposal)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}