package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.SigetConfig
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class SigetClient {

    fun config(idDepartment: Int, success: (SigetConfig) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().sigetService().config(idDepartment)
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