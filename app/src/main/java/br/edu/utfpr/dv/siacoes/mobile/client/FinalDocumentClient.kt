package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class FinalDocumentClient {

    fun find(idDepartment: Int, stage: Int, success: (FinalDocument) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().finalDocument().find(idDepartment, stage)
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