package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.SigesConfig
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class SigesClient {

    fun config(idDepartment: Int, success: (SigesConfig) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().sigesService().config(idDepartment)
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