package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.InternshipJury
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class InternshipJuryClient {

    fun listByStudent(success: (List<InternshipJury>) -> Unit,
                      failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().internshipJuryService().listByStudent()
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