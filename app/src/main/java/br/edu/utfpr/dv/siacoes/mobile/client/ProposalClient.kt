package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
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

}