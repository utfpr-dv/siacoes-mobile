package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Thesis
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class ThesisClient {

    fun findCurrent(idDepartment: Int, success: (Thesis) -> Unit,
                    failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().thesisService().findCurrent(idDepartment)
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