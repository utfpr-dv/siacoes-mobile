package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Jury
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class JuryClient {

    fun listByStudent(success: (List<Jury>) -> Unit,
                      failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().juryService().listByStudent()
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