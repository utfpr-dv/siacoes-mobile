package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.SigacConfig
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class SigacClient {

    fun config(idDepartment: Int, success: (SigacConfig) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().sigacService().config(idDepartment)
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